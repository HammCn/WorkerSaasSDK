package com.qtmtax.sdk.model.task.push;

import com.qtmtax.sdk.common.base.AbstractRequest;

/**
 * <h1>自动签约报名任务请求</h1>
 *
 * @author zhoul
 */
public class TaskPushRequest extends AbstractRequest<TaskPushResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "task/push";
    }

    private Long taskId;

    private String realName;

    private String idCard;

    private String phone;

    public Long getTaskId() {
        return taskId;
    }

    public TaskPushRequest setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public TaskPushRequest setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public TaskPushRequest setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public TaskPushRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
