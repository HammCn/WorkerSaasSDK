package com.qtmtax.sdk.model.enterprise.park;

/**
 * <h1>园区模型</h1>
 *
 * @author zhoul
 */
public class ParkModel {
    /**
     * <h2>园区ID</h2>
     */
    private Long id;

    /**
     * <h2>园区名称</h2>
     */
    private String name;

    /**
     * <h2>统一信用代码</h2>
     */
    private String code;

    /**
     * <h2>获取园区ID</h2>
     *
     * @return 园区ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <h2>设置园区ID</h2>
     *
     * @param id 园区ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <h2>获取园区名称</h2>
     *
     * @return 园区名称
     */
    public String getName() {
        return name;
    }

    /**
     * <h2>设置园区名称</h2>
     *
     * @param name 园区名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <h2>获取统一信用代码</h2>
     *
     * @return 统一信用代码
     */
    public String getCode() {
        return code;
    }

    /**
     * <h2>设置统一信用代码</h2>
     *
     * @param code 统一信用代码
     */
    public void setCode(String code) {
        this.code = code;
    }
}
