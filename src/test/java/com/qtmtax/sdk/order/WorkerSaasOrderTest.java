package com.qtmtax.sdk.order;

import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QtmTaxConstant;
import com.qtmtax.sdk.common.base.QuantumTaxJson;
import com.qtmtax.sdk.common.enums.QuantumTaxArithmetic;
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
     * <h2>日志</h2>
     */
    private static final Log log = LogFactory.getLog(WorkerSaasOrderTest.class);

    /**
     * <h2>WorkerSaas客户端</h2>
     */
    private static final QtmTaxClient QTM_TAX_CLIENT;

    static {
        QtmTaxConfig qtmTaxConfig = QtmTaxConfig.create()
                .setAppKey("NO9pn4tMn3aIvwX95CyxFlFzexXmzOFp")
                .setAppSecret("xNBf8CcKJW1GImCiVt1LHWFb68hDOLcARrNA5rTCACY=")
                .setGateway(QtmTaxConstant.GATEWAY_SANDBOX)
                .setArithmetic(QuantumTaxArithmetic.AES);
        QTM_TAX_CLIENT = QtmTaxClient.create(qtmTaxConfig);
    }

    public static void main(String[] args) {
        // 创建订单
        String outerTradeNo = create();

        // 查询已创建的订单
        query("D202410010000000001");
    }

    /**
     * <h2>创建订单</h2>
     *
     * @return 外部订单号
     */
    private static String create() {
        // 设置参数
        OrderCreateRequest request = new OrderCreateRequest()
                .setOuterTradeNo("D202410010000000004")
                .setBizAccount("13888888888")
                .setTaskId(1L)
                .setBalance(1D)
                .setRealName("马建")
                .setPhone("18523749565")
                .setPayAccount("18523749565")
                .setIdCardType(IdCardType.CHINA_ID_CARD)
                .setIdCard("500240199110030157");
        log.info(String.format("创建订单请求数据: %s", QuantumTaxJson.toString(request)));
        OrderCreateResponse response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("创建订单响应数据: %s", QuantumTaxJson.toString(response)));
        return response.getOrder().getOuterTradeNo();
    }

    /**
     * <h2>查询订单</h2>
     *
     * @param outerTradeNo 外部订单号
     */
    private static void query(String outerTradeNo) {
        OrderQueryRequest request = new OrderQueryRequest()
                .setOuterTradeNo(outerTradeNo);
        log.info(String.format("查询订单请求数据: %s", QuantumTaxJson.toString(request)));
        OrderQueryResponse response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("查询订单响应数据: %s", QuantumTaxJson.toString(response)));
    }
}
