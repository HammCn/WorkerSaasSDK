package com.workersaas.sdk.task;

import com.workersaas.sdk.Config;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.common.base.WorkerSaasClient;
import com.workersaas.sdk.common.base.WorkerSaasConfig;
import com.workersaas.sdk.common.enums.WorkerSaasArithmetic;
import com.workersaas.sdk.model.task.push.TaskPushRequest;
import com.workersaas.sdk.model.task.push.TaskPushResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <h1>任务测试</h1>
 */
public class WorkerSaasTaskPushTest {
    /**
     * 日志
     */
    private static final Log log = LogFactory.getLog(WorkerSaasTaskPushTest.class);

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
        TaskPushRequest request = new TaskPushRequest()
                .setTaskId(1L)
                .setIdCard("110101199001011234")
                .setRealName("张三")
                .setPhone("13800000000");
        log.info(String.format("报名任务参数: %s", Json.toString(request)));
        TaskPushResponse response = CLIENT.request(request);
        log.info(String.format("报名任务返回: %s", Json.toString(response)));
    }

}
