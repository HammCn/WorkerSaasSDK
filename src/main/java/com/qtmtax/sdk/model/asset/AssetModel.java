package com.qtmtax.sdk.model.asset;

/**
 * <h1>附件模型</h1>
 *
 * @author Hamm.cn
 */
public class AssetModel {
    /**
     * 附件类型
     */
    private String category;

    /**
     * 附件地址
     */
    private String url;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
