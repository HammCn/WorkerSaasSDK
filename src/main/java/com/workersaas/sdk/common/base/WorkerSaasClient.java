package com.workersaas.sdk.common.base;

import com.workersaas.sdk.common.enums.WorkerSaasErrorCode;
import com.workersaas.sdk.common.util.AesUtil;
import com.workersaas.sdk.common.util.DebugUtil;
import com.workersaas.sdk.common.util.HttpUtil;
import com.workersaas.sdk.common.util.RsaUtil;
import com.workersaas.sdk.model.order.OrderModel;

import java.util.Objects;

/**
 * <h1>请求客户端</h1>
 *
 * @author Hamm.cn
 */
public class WorkerSaasClient {
    /**
     * 禁止外部实例化
     */
    private WorkerSaasClient() {
    }

    /**
     * 配置
     */
    private WorkerSaasConfig workerSaasConfig;

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
            throw new WorkerSaasException(exception.getMessage());
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
        switch (workerSaasConfig.getArithmetic()) {
            case RSA:
                content = RsaUtil.create().setPublicKey(workerSaasConfig.getAppSecret()).decrypt(content);
                break;
            case AES:
                content = AesUtil.create().setKey(workerSaasConfig.getAppSecret()).decrypt(content);
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
        return encrypt(Json.toString(request));
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
        switch (workerSaasConfig.getArithmetic()) {
            case RSA:
                content = RsaUtil.create().setPublicKey(workerSaasConfig.getPublicKey()).encrypt(content);
                break;
            case AES:
                content = AesUtil.create().setKey(workerSaasConfig.getAppSecret()).encrypt(content);
                break;
            default:
        }
        DebugUtil.show("加密结果", content);
        return content;
    }

    /**
     * 创建Client
     *
     * @param workerSaasConfig 应用
     * @return Client
     * @see WorkerSaasConfig#create()
     */
    public static WorkerSaasClient create(WorkerSaasConfig workerSaasConfig) {
        if (Objects.isNull(workerSaasConfig)) {
            throw new IllegalArgumentException("无效的Config配置");
        }
        WorkerSaasClient workerSaasClient = new WorkerSaasClient();
        workerSaasClient.workerSaasConfig = workerSaasConfig;
        return workerSaasClient;
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
        WorkerSaasRequest workerSaasRequest = new WorkerSaasRequest()
                .setAppKey(workerSaasConfig.getAppKey())
                .setContent(encrypt(request));
        String sign = workerSaasRequest.sign(workerSaasConfig.getAppSecret());
        workerSaasRequest.setSignature(sign);
        final String body = Json.toString(workerSaasRequest);
        final String url = workerSaasConfig.getGateway() + request.getApiUrl();
        DebugUtil.show("请求地址", url);
        DebugUtil.show("请求包体", body);
        String response = HttpUtil.post(url, body);
        DebugUtil.show("响应包体", response);
        Json<?> json = Json.parse(response, Json.class);
        if (WorkerSaasErrorCode.SUCCESS.getCode() != json.getCode()) {
            throw new WorkerSaasException(json.getCode(), json.getMessage());
        }
        return json.getData();
    }

    /**
     * 获取通知的请求内容
     *
     * @param json 通知内容
     * @return 请求内容
     */
    private String getNotifyRequestContent(String json) {
        WorkerSaasRequest request = Json.parse(json, WorkerSaasRequest.class);
        String sign = request.sign(workerSaasConfig.getAppSecret());
        if (!sign.equals(request.getSignature())) {
            throw new WorkerSaasException("签名验证失败");
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
        return Json.parse(content, OrderModel.class);
    }
}
