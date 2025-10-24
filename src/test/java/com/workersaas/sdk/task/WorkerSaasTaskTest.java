package com.workersaas.sdk.task;

import com.workersaas.sdk.Config;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.common.base.WorkerSaasClient;
import com.workersaas.sdk.common.base.WorkerSaasConfig;
import com.workersaas.sdk.common.enums.WorkerSaasArithmetic;
import com.workersaas.sdk.model.task.list.TaskGetListRequest;
import com.workersaas.sdk.model.task.list.TaskGetListResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <h1>任务测试</h1>
 */
public class WorkerSaasTaskTest {
    /**
     * 日志
     */
    private static final Log log = LogFactory.getLog(WorkerSaasTaskTest.class);

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
        // 获取任务列表
        getList();
    }

    /**
     * 获取任务列表
     */
    private static void getList() {
        TaskGetListRequest request = new TaskGetListRequest();
        log.info(String.format("获取任务列表请求数据: %s", Json.toString(request)));
        TaskGetListResponse response = CLIENT.request(request);
        log.info(String.format("获取任务列表响应数据: %s", Json.toString(response.getTaskList())));
    }

}
