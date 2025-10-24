package com.workersaas.sdk.order;

import com.workersaas.sdk.Config;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.common.base.WorkerSaasClient;
import com.workersaas.sdk.common.base.WorkerSaasConfig;
import com.workersaas.sdk.common.enums.WorkerSaasArithmetic;
import com.workersaas.sdk.enums.IdCardType;
import com.workersaas.sdk.model.order.create.OrderCreateRequest;
import com.workersaas.sdk.model.order.create.OrderCreateResponse;
import com.workersaas.sdk.model.order.query.OrderQueryRequest;
import com.workersaas.sdk.model.order.query.OrderQueryResponse;
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
    private static final WorkerSaasClient CLIENT;

    static {
        WorkerSaasConfig workerSaasConfig = WorkerSaasConfig.create()
                .setAppKey(Config.APP_KEY)
                .setAppSecret(Config.APP_SECRET)
                .setGateway(Config.GATEWAY)
                .setArithmetic(WorkerSaasArithmetic.AES);
        CLIENT = WorkerSaasClient.create(workerSaasConfig);
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
        log.info(String.format("创建订单请求数据: %s", Json.toString(request)));
        OrderCreateResponse response = CLIENT.request(request);
        log.info(String.format("创建订单响应数据: %s", Json.toString(response)));
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
        log.info(String.format("查询订单请求数据: %s", Json.toString(request)));
        OrderQueryResponse response = CLIENT.request(request);
        log.info(String.format("查询订单响应数据: %s", Json.toString(response)));
    }
}
