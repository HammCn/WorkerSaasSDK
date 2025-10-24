package com.qtmtax.sdk.task;

import com.qtmtax.sdk.Config;
import com.qtmtax.sdk.common.base.QtmTaxClient;
import com.qtmtax.sdk.common.base.QtmTaxConfig;
import com.qtmtax.sdk.common.base.QtmTaxJson;
import com.qtmtax.sdk.common.enums.QtmTaxArithmetic;
import com.qtmtax.sdk.model.task.list.TaskGetListRequest;
import com.qtmtax.sdk.model.task.list.TaskGetListResponse;
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
        // 获取任务列表
        getList();
    }

    /**
     * 获取任务列表
     */
    private static void getList() {
        TaskGetListRequest request = new TaskGetListRequest();
        log.info(String.format("获取任务列表请求数据: %s", QtmTaxJson.toString(request)));
        TaskGetListResponse response = QTM_TAX_CLIENT.request(request);
        log.info(String.format("获取任务列表响应数据: %s", QtmTaxJson.toString(response.getTaskList())));
    }

}
