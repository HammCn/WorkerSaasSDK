package com.qtmtax.sdk.enterprise.park;

import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QtmTaxConstant;
import com.qtmtax.sdk.common.base.QuantumTaxJson;
import com.qtmtax.sdk.common.enums.QuantumTaxArithmetic;
import com.qtmtax.sdk.model.enterprise.EnterpriseParkModel;
import com.qtmtax.sdk.model.enterprise.park.list.EnterpriseParkGetListRequest;
import com.qtmtax.sdk.model.enterprise.park.list.EnterpriseParkGetListResponse;
import com.qtmtax.sdk.model.enterprise.park.query.EnterpriseParkQueryRequest;
import com.qtmtax.sdk.model.enterprise.park.query.EnterpriseParkQueryResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * <h1>企业园区测试</h1>
 *
 * @author zhoul
 */
public class WorkerSaasEnterpriseParkTest {
    /**
     * 日志
     */
    private static final Log log = LogFactory.getLog(WorkerSaasEnterpriseParkTest.class);

    /**
     * WorkerSaas客户端
     */
    private static final QtmTaxClient client;

    static {
        QtmTaxConfig qtmTaxConfig = QtmTaxConfig.create()
                .setAppKey("NO9pn4tMn3aIvwX95CyxFlFzexXmzOFp")
                .setAppSecret("xNBf8CcKJW1GImCiVt1LHWFb68hDOLcARrNA5rTCACY=")
                .setGateway(QtmTaxConstant.GATEWAY_SANDBOX)
                .setArithmetic(QuantumTaxArithmetic.AES);
        client = QtmTaxClient.create(qtmTaxConfig);
    }

    public static void main(String[] args) {
        // 查询企业园区列表
        List<EnterpriseParkModel> enterpriseParkList = getList();
        long enterpriseParkId = enterpriseParkList.isEmpty() ? 1L : enterpriseParkList.get(0).getId();

        // 查询企业园区详情
        query(enterpriseParkId);
    }

    /**
     * 获取企业园区列表
     */
    private static List<EnterpriseParkModel> getList() {
        EnterpriseParkGetListRequest request = new EnterpriseParkGetListRequest();
        log.info(String.format("查询企业园区可用列表请求数据: %s", QuantumTaxJson.toString(request)));
        EnterpriseParkGetListResponse response = client.request(request);
        log.info(String.format("查询企业园区可用列表响应数据: %s", QuantumTaxJson.toString(response)));
        return response.getEnterpriseParkList();
    }

    private static void query(long enterpriseParkId) {
        EnterpriseParkQueryRequest request = new EnterpriseParkQueryRequest();
        request.setId(enterpriseParkId);
        log.info(String.format("查询企业园区详情请求数据: %s", QuantumTaxJson.toString(request)));
        EnterpriseParkQueryResponse response = client.request(request);
        log.info(String.format("查询企业园区详情响应数据: %s", QuantumTaxJson.toString(response)));
    }

}
