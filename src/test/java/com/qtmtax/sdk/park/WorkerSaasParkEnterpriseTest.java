package com.qtmtax.sdk.park;

import com.qtmtax.sdk.Config;
import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QtmTaxConstant;
import com.qtmtax.sdk.common.base.QuantumTaxJson;
import com.qtmtax.sdk.common.enums.QuantumTaxArithmetic;
import com.qtmtax.sdk.model.enterprise.park.EnterpriseParkModel;
import com.qtmtax.sdk.model.enterprise.park.list.EnterpriseParkGetListRequest;
import com.qtmtax.sdk.model.enterprise.park.list.EnterpriseParkGetListResponse;
import com.qtmtax.sdk.model.enterprise.park.query.EnterpriseParkQueryRequest;
import com.qtmtax.sdk.model.enterprise.park.query.EnterpriseParkQueryResponse;
import com.qtmtax.sdk.model.park.enterprise.ParkEnterpriseModel;
import com.qtmtax.sdk.model.park.enterprise.list.ParkEnterpriseGetListRequest;
import com.qtmtax.sdk.model.park.enterprise.list.ParkEnterpriseGetListResponse;
import com.qtmtax.sdk.model.park.enterprise.query.ParkEnterpriseQueryRequest;
import com.qtmtax.sdk.model.park.enterprise.query.ParkEnterpriseQueryResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * <h1>企业园区测试</h1>
 *
 * @author zhoul
 */
public class WorkerSaasParkEnterpriseTest {
    /**
     * 日志
     */
    private static final Log log = LogFactory.getLog(WorkerSaasParkEnterpriseTest.class);

    /**
     * WorkerSaas客户端
     */
    private static final QtmTaxClient client;

    static {
        QtmTaxConfig qtmTaxConfig = QtmTaxConfig.create()
                .setAppKey(Config.APP_KEY)
                .setAppSecret(Config.APP_SECRET)
                .setGateway(Config.GATEWAY)
                .setArithmetic(QuantumTaxArithmetic.AES);
        client = QtmTaxClient.create(qtmTaxConfig);
    }

    public static void main(String[] args) {
        // 查询企业园区列表
        List<ParkEnterpriseModel> enterpriseParkList = getList();
        long enterpriseParkId = enterpriseParkList.isEmpty() ? 1L : enterpriseParkList.get(0).getId();

        // 查询企业园区详情
        query(enterpriseParkId);
    }

    /**
     * 获取企业园区列表
     */
    private static List<ParkEnterpriseModel> getList() {
        ParkEnterpriseGetListRequest request = new ParkEnterpriseGetListRequest();
        log.info(String.format("查询企业园区可用列表请求数据: %s", QuantumTaxJson.toString(request)));
        ParkEnterpriseGetListResponse response = client.request(request);
        log.info(String.format("查询企业园区可用列表响应数据: %s", QuantumTaxJson.toString(response)));
        return response.getParkEnterpriseList();
    }

    private static void query(long enterpriseParkId) {
        ParkEnterpriseQueryRequest request = new ParkEnterpriseQueryRequest();
        request.setId(enterpriseParkId);
        log.info(String.format("查询企业园区详情请求数据: %s", QuantumTaxJson.toString(request)));
        ParkEnterpriseQueryResponse response = client.request(request);
        log.info(String.format("查询企业园区详情响应数据: %s", QuantumTaxJson.toString(response)));
    }

}
