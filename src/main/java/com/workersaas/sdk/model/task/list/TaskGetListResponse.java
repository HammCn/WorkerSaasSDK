package com.workersaas.sdk.model.task.list;

import com.workersaas.sdk.common.base.AbstractResponse;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.model.task.TaskModel;

import java.util.List;

/**
 * <h1>获取任务列表</h1>
 *
 * @author zhoul
 */
public class TaskGetListResponse extends AbstractResponse<TaskGetListResponse> {

    /**
     * 任务列表
     */
    private List<TaskModel> taskList;

    /**
     * 解析数据
     *
     * @param data 解密后的data数据
     */
    @Override
    public TaskGetListResponse parseData(String data) {
        return this.setTaskList(Json.parseList(data, TaskModel[].class));
    }

    /**
     * 获取任务列表
     *
     * @return 任务列表
     */
    public List<TaskModel> getTaskList() {
        return taskList;
    }

    /**
     * 设置任务列表
     *
     * @param taskList 任务列表
     * @return 当前实例
     */
    public TaskGetListResponse setTaskList(List<TaskModel> taskList) {
        this.taskList = taskList;
        return this;
    }
}
