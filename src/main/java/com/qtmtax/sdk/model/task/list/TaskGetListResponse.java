package com.qtmtax.sdk.model.task.list;

import com.qtmtax.sdk.common.base.AbstractResponse;
import com.qtmtax.sdk.common.base.QuantumTaxJson;
import com.qtmtax.sdk.model.task.TaskModel;

import java.util.List;

/**
 * <h1>获取任务列表</h1>
 *
 * @author zhoul
 */
public class TaskGetListResponse extends AbstractResponse<TaskGetListResponse> {

    /**
     * <h2>任务列表</h2>
     */
    private List<TaskModel> taskList;

    /**
     * <h2>解析数据</h2>
     *
     * @param data 解密后的data数据
     */
    @Override
    public TaskGetListResponse parseData(String data) {
        return this.setTaskList(QuantumTaxJson.parseList(data, TaskModel[].class));
    }

    /**
     * <h2>获取任务列表</h2>
     *
     * @return 任务列表
     */
    public List<TaskModel> getTaskList() {
        return taskList;
    }

    /**
     * <h2>设置任务列表</h2>
     *
     * @param taskList 任务列表
     * @return 当前实例
     */
    public TaskGetListResponse setTaskList(List<TaskModel> taskList) {
        this.taskList = taskList;
        return this;
    }
}
