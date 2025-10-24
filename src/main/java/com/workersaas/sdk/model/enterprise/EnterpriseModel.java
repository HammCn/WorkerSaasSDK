package com.workersaas.sdk.model.enterprise;

import com.workersaas.sdk.model.asset.AssetModel;

import java.util.List;

/**
 * <h1>企业模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseModel {
    /**
     * 企业ID
     */
    private Long id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 统一信用代码
     */
    private String code;

    /**
     * 附件列表
     */
    private List<AssetModel> assetList;

    /**
     * 获取企业ID
     *
     * @return 企业ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置企业ID
     *
     * @param id 企业ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取企业名称
     *
     * @return 企业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业名称
     *
     * @param name 企业名称
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

    /**
     * 获取附件列表
     *
     * @return 附件列表
     */
    public List<AssetModel> getAssetList() {
        return assetList;
    }

    /**
     * 添加附件
     *
     * @param assetList 附件列表
     */
    public void setAssetList(List<AssetModel> assetList) {
        this.assetList = assetList;
    }
}
