package com.qtmtax.sdk.common.base;

import com.qtmtax.sdk.common.enums.QtmTaxErrorCode;
import com.qtmtax.sdk.common.util.AesUtil;
import com.qtmtax.sdk.common.util.DebugUtil;
import com.qtmtax.sdk.common.util.HttpUtil;
import com.qtmtax.sdk.common.util.RsaUtil;
import com.qtmtax.sdk.model.order.OrderModel;

import java.util.Objects;

/**
 * <h1>QtmTaxClient</h1>
 *
 * @author Hamm.cn
 */
public class QtmTaxClient {
    /**
     * 禁止外部实例化
     */
    private QtmTaxClient() {
    }

    /**
     * 配置
     */
    private QtmTaxConfig qtmTaxConfig;

    /**
     * 发起请求
     *
     * @param request 请求对象
     * @return 响应对象
     */
    public final <REQ extends AbstractRequest<RES>, RES extends AbstractResponse<RES>> RES request(REQ request) {
        return decrypt(sendRequest(request), request.getResponseClass());
    }

    /**
     * 解密
     *
     * @param content     加密后的数据
     * @param targetClass 目标类
     * @return 解密后的对象
     */
    public final <RES extends AbstractResponse<RES>> RES decrypt(String content, Class<RES> targetClass) {
        content = decrypt(content);
        if (Objects.isNull(content)) {
            return null;
        }
        try {
            RES res = targetClass.newInstance();
            res.parseData(content);
            return res;
        } catch (InstantiationException | IllegalAccessException exception) {
            DebugUtil.show("创建对象失败", exception.getMessage());
            throw new QtmTaxException(exception.getMessage());
        }
    }

    /**
     * 解密
     *
     * @param content 加密后的数据
     * @return 解密后的字符串
     */
    public final String decrypt(String content) {
        if (Objects.isNull(content)) {
            return null;
        }
        DebugUtil.show("解密数据", content);
        switch (qtmTaxConfig.getArithmetic()) {
            case RSA:
                content = RsaUtil.create().setPublicKey(qtmTaxConfig.getAppSecret()).decrypt(content);
                break;
            case AES:
                content = AesUtil.create().setKey(qtmTaxConfig.getAppSecret()).decrypt(content);
                break;
            default:
        }
        DebugUtil.show("解密结果", content);
        return content;
    }

    /**
     * 加密
     *
     * @param request 请求对象
     * @return 加密后的内容
     */
    public final <REQ extends AbstractRequest<RES>, RES extends AbstractResponse<RES>> String encrypt(REQ request) {
        if (Objects.isNull(request)) {
            return null;
        }
        return encrypt(QtmTaxJson.toString(request));
    }

    /**
     * 加密
     *
     * @param content 需要加密的字符串
     * @return 加密后的内容
     */
    public final String encrypt(String content) {
        if (Objects.isNull(content)) {
            return null;
        }
        DebugUtil.show("加密数据", content);
        switch (qtmTaxConfig.getArithmetic()) {
            case RSA:
                content = RsaUtil.create().setPublicKey(qtmTaxConfig.getPublicKey()).encrypt(content);
                break;
            case AES:
                content = AesUtil.create().setKey(qtmTaxConfig.getAppSecret()).encrypt(content);
                break;
            default:
        }
        DebugUtil.show("加密结果", content);
        return content;
    }

    /**
     * 创建Client
     *
     * @param qtmTaxConfig 应用
     * @return Client
     * @see QtmTaxConfig#create()
     */
    public static QtmTaxClient create(QtmTaxConfig qtmTaxConfig) {
        if (Objects.isNull(qtmTaxConfig)) {
            throw new IllegalArgumentException("无效的Config配置");
        }
        QtmTaxClient qtmTaxClient = new QtmTaxClient();
        qtmTaxClient.qtmTaxConfig = qtmTaxConfig;
        return qtmTaxClient;
    }

    /**
     * 发起请求
     *
     * @param request 请求对象
     * @param <RES>   响应类型
     * @param <REQ>   请求类型
     * @return 数据字符串
     */
    private <RES extends AbstractResponse<RES>, REQ extends AbstractRequest<RES>> String sendRequest(REQ request) {
        QtmTaxRequest quantumTaxRequest = new QtmTaxRequest()
                .setAppKey(qtmTaxConfig.getAppKey())
                .setContent(encrypt(request));
        String sign = quantumTaxRequest.sign(qtmTaxConfig.getAppSecret());
        quantumTaxRequest.setSignature(sign);
        final String body = QtmTaxJson.toString(quantumTaxRequest);
        final String url = qtmTaxConfig.getGateway() + request.getApiUrl();
        DebugUtil.show("请求地址", url);
        DebugUtil.show("请求包体", body);
        String response = HttpUtil.post(url, body);
        DebugUtil.show("响应包体", response);
        QtmTaxJson<?> qtmTaxJson = QtmTaxJson.parse(response, QtmTaxJson.class);
        if (QtmTaxErrorCode.SUCCESS.getCode() != qtmTaxJson.getCode()) {
            throw new QtmTaxException(qtmTaxJson.getCode(), qtmTaxJson.getMessage());
        }
        return qtmTaxJson.getData();
    }

    /**
     * 获取通知的请求内容
     *
     * @param json 通知内容
     * @return 请求内容
     */
    private String getNotifyRequestContent(String json) {
        QtmTaxRequest request = QtmTaxJson.parse(json, QtmTaxRequest.class);
        String sign = request.sign(qtmTaxConfig.getAppSecret());
        if (!sign.equals(request.getSignature())) {
            throw new QtmTaxException("签名验证失败");
        }
        return decrypt(request.getContent());
    }

    /**
     * 获取通知的订单信息
     *
     * @param json 通知内容
     * @return 订单信息
     */
    public OrderModel getNotifyOrder(String json) {
        String content = getNotifyRequestContent(json);
        return QtmTaxJson.parse(content, OrderModel.class);
    }
}
