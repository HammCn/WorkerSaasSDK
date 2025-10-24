package com.qtmtax.sdk.model.task;

import com.qtmtax.sdk.model.enterprise.park.EnterpriseParkModel;

/**
 * <h1>任务模型</h1>
 *
 * @author zhoul
 */
public class TaskModel {

    /**
     * 任务ID
     */
    private Long id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 项目ID
     */
    private String project;

    /**
     * 企业园区
     */
    private EnterpriseParkModel enterprisePark;

    /**
     * 获取任务ID
     *
     * @return 任务ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置任务ID
     *
     * @param id 任务ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取任务名称
     *
     * @return 任务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置任务名称
     *
     * @param name 任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取项目ID
     *
     * @return 项目ID
     */
    public String getProject() {
        return project;
    }

    /**
     * 设置项目ID
     *
     * @param project 项目ID
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * 获取企业园区
     *
     * @return 企业园区
     */
    public EnterpriseParkModel getEnterprisePark() {
        return enterprisePark;
    }

    /**
     * 设置企业园区
     *
     * @param enterprisePark 企业园区
     */
    public void setEnterprisePark(EnterpriseParkModel enterprisePark) {
        this.enterprisePark = enterprisePark;
    }
}
