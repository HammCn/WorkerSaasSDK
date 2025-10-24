package com.qtmtax.sdk.enterprise.park;

import com.qtmtax.sdk.Config;
import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QtmTaxJson;
import com.qtmtax.sdk.common.enums.QtmTaxArithmetic;
import com.qtmtax.sdk.model.enterprise.park.EnterpriseParkModel;
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
                .setAppKey(Config.APP_KEY)
                .setAppSecret(Config.APP_SECRET)
                .setGateway(Config.GATEWAY)
                .setArithmetic(QtmTaxArithmetic.AES);
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
        log.info(String.format("查询企业园区可用列表请求数据: %s", QtmTaxJson.toString(request)));
        EnterpriseParkGetListResponse response = client.request(request);
        log.info(String.format("查询企业园区可用列表响应数据: %s", QtmTaxJson.toString(response)));
        return response.getEnterpriseParkList();
    }

    private static void query(long enterpriseParkId) {
        EnterpriseParkQueryRequest request = new EnterpriseParkQueryRequest();
        request.setId(enterpriseParkId);
        log.info(String.format("查询企业园区详情请求数据: %s", QtmTaxJson.toString(request)));
        EnterpriseParkQueryResponse response = client.request(request);
        log.info(String.format("查询企业园区详情响应数据: %s", QtmTaxJson.toString(response)));
    }

}
