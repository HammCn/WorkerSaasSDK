package com.workersaas.sdk.tax;

import com.workersaas.sdk.Config;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.common.base.WorkerSaasClient;
import com.workersaas.sdk.common.base.WorkerSaasConfig;
import com.workersaas.sdk.common.enums.WorkerSaasArithmetic;
import com.workersaas.sdk.model.tax.calc.TaxCalcRequest;
import com.workersaas.sdk.model.tax.calc.TaxCalcResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <h1>税额计算测试</h1>
 */
public class WorkerSaasTaxCalcTest {
    /**
     * 日志
     */
    private static final Log log = LogFactory.getLog(WorkerSaasTaxCalcTest.class);

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
        TaxCalcRequest request = new TaxCalcRequest()
                .setBalance(80000D)
                .setIdCard("500240199101010101");
        log.info(String.format("计算个人所得税请求: %s", Json.toString(request)));
        TaxCalcResponse response = CLIENT.request(request);
        log.info(String.format("计算个人所得税响应: %s", response.getTaxCalc().getTax()));

        request = new TaxCalcRequest()
                .setBalance(80000D)
                .setIdCard("500240199101010101")
                .setIsEnterpriseTax(true)
        ;
        log.info(String.format("计算价税合计请求: %s", Json.toString(request)));
        response = CLIENT.request(request);
        log.info(String.format("计算价税合计响应: %s", response.getTaxCalc().getTax()));
    }

}
