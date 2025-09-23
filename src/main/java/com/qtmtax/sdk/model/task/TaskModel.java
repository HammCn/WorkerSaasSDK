package com.qtmtax.sdk.model.task;

import com.qtmtax.sdk.model.enterprise.EnterpriseParkModel;

/**
 * <h1>任务模型</h1>
 *
 * @author zhoul
 */
public class TaskModel {

    /**
     * <h2>任务ID</h2>
     */
    private Long id;

    /**
     * <h2>任务名称</h2>
     */
    private String name;

    /**
     * <h2>项目ID</h2>
     */
    private String project;

    /**
     * <h2>企业园区</h2>
     */
    private EnterpriseParkModel enterprisePark;

    /**
     * <h2>获取任务ID</h2>
     *
     * @return 任务ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <h2>设置任务ID</h2>
     *
     * @param id 任务ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <h2>获取任务名称</h2>
     *
     * @return 任务名称
     */
    public String getName() {
        return name;
    }

    /**
     * <h2>设置任务名称</h2>
     *
     * @param name 任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <h2>获取项目ID</h2>
     *
     * @return 项目ID
     */
    public String getProject() {
        return project;
    }

    /**
     * <h2>设置项目ID</h2>
     *
     * @param project 项目ID
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * <h2>获取企业园区</h2>
     *
     * @return 企业园区
     */
    public EnterpriseParkModel getEnterprisePark() {
        return enterprisePark;
    }

    /**
     * <h2>设置企业园区</h2>
     *
     * @param enterprisePark 企业园区
     */
    public void setEnterprisePark(EnterpriseParkModel enterprisePark) {
        this.enterprisePark = enterprisePark;
    }
}
