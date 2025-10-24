package com.qtmtax.sdk.tax;

import com.qtmtax.sdk.Config;
import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QtmTaxJson;
import com.qtmtax.sdk.common.enums.QtmTaxArithmetic;
import com.qtmtax.sdk.model.tax.calc.TaxCalcRequest;
import com.qtmtax.sdk.model.tax.calc.TaxCalcResponse;
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
        TaxCalcRequest request = new TaxCalcRequest()
                .setBalance(80000D)
                .setIdCard("500240199101010101");
        log.info(String.format("计算个人所得税请求: %s", QtmTaxJson.toString(request)));
        TaxCalcResponse response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("计算个人所得税响应: %s", response.getTaxCalc().getTax()));

        request = new TaxCalcRequest()
                .setBalance(80000D)
                .setIdCard("500240199101010101")
                .setIsEnterpriseTax(true)
        ;
        log.info(String.format("计算价税合计请求: %s", QtmTaxJson.toString(request)));
        response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("计算价税合计响应: %s", response.getTaxCalc().getTax()));
    }

}
