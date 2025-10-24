package com.workersaas.sdk.model.task.list;

import com.workersaas.sdk.common.base.AbstractRequest;

/**
 * <h1>获取任务列表请求模型</h1>
 *
 * @author zhoul
 */
public class TaskGetListRequest extends AbstractRequest<TaskGetListResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "task/getList";
    }
}
