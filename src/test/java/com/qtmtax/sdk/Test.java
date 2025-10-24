package com.qtmtax.sdk;

import com.qtmtax.sdk.common.base.*;
import com.qtmtax.sdk.common.enums.QtmTaxArithmetic;
import com.qtmtax.sdk.model.order.OrderModel;

public class Test {
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

    public static void main(String... args) {
        String json = "{\"appKey\":\"NO9pn4tMn3aIvwX95CyxFlFzexXmzOFp\",\"version\":10000,\"timestamp\":1758634064074,\"content\":\"YFFpogkx4G9qOD2NLu+zVBgVXW9eOKmY+uCFFdogcLUvfGz49pXRwVbmqydS6qYVSR5yjaKeyTmTiVWxxsLsgutNlFTv6azDXoJ/WMajayBinuxUh2HqsFWkK5cZm6drqnQp32+ysBNtcGl3uhnwbW94b+hXjp9Cb6el2q0Saw8=\",\"nonce\":\"7jSqQ8IwNVCoeMt8cGbAi9RqNT60ejVq\",\"signature\":\"76bbdd62291dad29995cc1381901242d2dfe9237\"}";
        OrderModel notifyOrder = QTM_TAX_CLIENT.getNotifyOrder(json);
        System.out.println(notifyOrder.getOuterTradeNo());
    }
}