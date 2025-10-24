package com.workersaas.sdk.enterprise.park;

import com.workersaas.sdk.Config;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.common.base.WorkerSaasClient;
import com.workersaas.sdk.common.base.WorkerSaasConfig;
import com.workersaas.sdk.common.enums.WorkerSaasArithmetic;
import com.workersaas.sdk.model.enterprise.park.EnterpriseParkModel;
import com.workersaas.sdk.model.enterprise.park.list.EnterpriseParkGetListRequest;
import com.workersaas.sdk.model.enterprise.park.list.EnterpriseParkGetListResponse;
import com.workersaas.sdk.model.enterprise.park.query.EnterpriseParkQueryRequest;
import com.workersaas.sdk.model.enterprise.park.query.EnterpriseParkQueryResponse;
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
    private static final WorkerSaasClient client;

    static {
        WorkerSaasConfig workerSaasConfig = WorkerSaasConfig.create()
                .setAppKey(Config.APP_KEY)
                .setAppSecret(Config.APP_SECRET)
                .setGateway(Config.GATEWAY)
                .setArithmetic(WorkerSaasArithmetic.AES);
        client = WorkerSaasClient.create(workerSaasConfig);
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
        log.info(String.format("查询企业园区可用列表请求数据: %s", Json.toString(request)));
        EnterpriseParkGetListResponse response = client.request(request);
        log.info(String.format("查询企业园区可用列表响应数据: %s", Json.toString(response)));
        return response.getEnterpriseParkList();
    }

    private static void query(long enterpriseParkId) {
        EnterpriseParkQueryRequest request = new EnterpriseParkQueryRequest();
        request.setId(enterpriseParkId);
        log.info(String.format("查询企业园区详情请求数据: %s", Json.toString(request)));
        EnterpriseParkQueryResponse response = client.request(request);
        log.info(String.format("查询企业园区详情响应数据: %s", Json.toString(response)));
    }

}
