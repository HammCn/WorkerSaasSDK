package com.workersaas.sdk;

import com.workersaas.sdk.common.base.WorkerSaasClient;
import com.workersaas.sdk.common.base.WorkerSaasConfig;
import com.workersaas.sdk.common.enums.WorkerSaasArithmetic;
import com.workersaas.sdk.model.order.OrderModel;

public class Test {
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

    public static void main(String... args) {
        String json = "{\"appKey\":\"NO9pn4tMn3aIvwX95CyxFlFzexXmzOFp\",\"version\":10000,\"timestamp\":1758634064074,\"content\":\"YFFpogkx4G9qOD2NLu+zVBgVXW9eOKmY+uCFFdogcLUvfGz49pXRwVbmqydS6qYVSR5yjaKeyTmTiVWxxsLsgutNlFTv6azDXoJ/WMajayBinuxUh2HqsFWkK5cZm6drqnQp32+ysBNtcGl3uhnwbW94b+hXjp9Cb6el2q0Saw8=\",\"nonce\":\"7jSqQ8IwNVCoeMt8cGbAi9RqNT60ejVq\",\"signature\":\"76bbdd62291dad29995cc1381901242d2dfe9237\"}";
        OrderModel notifyOrder = CLIENT.getNotifyOrder(json);
        System.out.println(notifyOrder.getOuterTradeNo());
    }
}