package com.qtmtax.sdk.order;

import com.qtmtax.sdk.Config;
import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QtmTaxJson;
import com.qtmtax.sdk.common.enums.QtmTaxArithmetic;
import com.qtmtax.sdk.enums.IdCardType;
import com.qtmtax.sdk.model.order.create.OrderCreateRequest;
import com.qtmtax.sdk.model.order.create.OrderCreateResponse;
import com.qtmtax.sdk.model.order.query.OrderQueryRequest;
import com.qtmtax.sdk.model.order.query.OrderQueryResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <h1>订单测试</h1>
 *
 * @author zhoul
 */
public class WorkerSaasOrderTest {

    /**
     * 日志
     */
    private static final Log log = LogFactory.getLog(WorkerSaasOrderTest.class);

    /**
     * WorkerSaas客户端
     */
    private static final QtmTaxClient QTM_TAX_CLIENT;

    static {
        QtmTaxConfig qtmTaxConfig = QtmTaxConfig.create()
                .setAppKey(Config.APP_KEY)
                .setAppSecret(Config.APP_SECRET)
                .setGateway(Config.GATEWAY)
                .setArithmetic(QtmTaxArithmetic.AES);
        QTM_TAX_CLIENT = QtmTaxClient.create(qtmTaxConfig);
    }

    public static void main(String[] args) {
        // 创建订单
        String outerTradeNo = create();

        // 查询已创建的订单
        query("D202410010000000001");
    }

    /**
     * 创建订单
     *
     * @return 外部订单号
     */
    private static String create() {
        // 设置参数
        OrderCreateRequest request = new OrderCreateRequest()
                .setOuterTradeNo("D202410010000000002")
                .setBizAccount("13888888888")
                .setTaskId(1L)
                .setBalance(1D)
                .setRealName("凌小云")
                .setPhone("17666666666")
                .setReason("服务费")
                .setPayAccount("17666666666")
                .setIdCardType(IdCardType.CHINA_ID_CARD)
                .setIdCard("500000000000");
        log.info(String.format("创建订单请求数据: %s", QtmTaxJson.toString(request)));
        OrderCreateResponse response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("创建订单响应数据: %s", QtmTaxJson.toString(response)));
        return response.getOrder().getOuterTradeNo();
    }

    /**
     * 查询订单
     *
     * @param outerTradeNo 外部订单号
     */
    private static void query(String outerTradeNo) {
        OrderQueryRequest request = new OrderQueryRequest()
                .setOuterTradeNo(outerTradeNo);
        log.info(String.format("查询订单请求数据: %s", QtmTaxJson.toString(request)));
        OrderQueryResponse response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("查询订单响应数据: %s", QtmTaxJson.toString(response)));
    }
}
