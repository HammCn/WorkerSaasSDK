package com.qtmtax.sdk.model.task.list;

import com.qtmtax.sdk.common.base.AbstractRequest;

/**
 * <h1>获取任务列表请求模型</h1>
 *
 * @author zhoul
 */
public class TaskGetListRequest extends AbstractRequest<TaskGetListResponse> {
    /**
     * <h2>API地址</h2>
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "task/getList";
    }
}
