package com.qtmtax.sdk.task;

import com.qtmtax.sdk.Config;
import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QuantumTaxJson;
import com.qtmtax.sdk.common.enums.QuantumTaxArithmetic;
import com.qtmtax.sdk.model.task.list.TaskGetListRequest;
import com.qtmtax.sdk.model.task.list.TaskGetListResponse;
import com.qtmtax.sdk.model.task.push.TaskPushRequest;
import com.qtmtax.sdk.model.task.push.TaskPushResponse;
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
    private static final QtmTaxClient QTM_TAX_CLIENT;

    static {
        QtmTaxConfig qtmTaxConfig = QtmTaxConfig.create()
                .setAppKey(Config.APP_KEY)
                .setAppSecret(Config.APP_SECRET)
                .setGateway(Config.GATEWAY)
                .setArithmetic(QuantumTaxArithmetic.AES);
        QTM_TAX_CLIENT = QtmTaxClient.create(qtmTaxConfig);
    }

    public static void main(String[] args) {
        TaskPushRequest request = new TaskPushRequest()
                .setTaskId(1L)
                .setIdCard("110101199001011234")
                .setRealName("张三")
                .setPhone("13800000000");
        log.info(String.format("报名任务参数: %s", QuantumTaxJson.toString(request)));
        TaskPushResponse response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("报名任务返回: %s", QuantumTaxJson.toString(response)));
    }

}
