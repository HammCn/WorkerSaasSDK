package com.workersaas.sdk.model.park;

/**
 * <h1>园区模型</h1>
 *
 * @author zhoul
 */
public class ParkModel {
    /**
     * 园区ID
     */
    private Long id;

    /**
     * 园区名称
     */
    private String name;

    /**
     * 统一信用代码
     */
    private String code;

    /**
     * 获取园区ID
     *
     * @return 园区ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置园区ID
     *
     * @param id 园区ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取园区名称
     *
     * @return 园区名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置园区名称
     *
     * @param name 园区名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取统一信用代码
     *
     * @return 统一信用代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置统一信用代码
     *
     * @param code 统一信用代码
     */
    public void setCode(String code) {
        this.code = code;
    }
}
