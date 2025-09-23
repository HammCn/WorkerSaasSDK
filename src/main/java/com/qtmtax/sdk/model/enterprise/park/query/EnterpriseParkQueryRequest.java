package com.qtmtax.sdk.model.enterprise.park.query;

import com.qtmtax.sdk.common.base.AbstractRequest;

/**
 * <h1>查询企业园区详情请求模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseParkQueryRequest extends AbstractRequest<EnterpriseParkQueryResponse> {
    /**
     * <h2>API地址</h2>
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "enterprisePark/query";
    }

    /**
     * <h2>企业园区ID</h2>
     */
    private Long id;

    /**
     * <h2>企业园区ID</h2>
     *
     * @return 企业园区ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <h2>设置企业园区ID</h2>
     *
     * @param id 当前实例
     * @return 当前实例
     */
    public EnterpriseParkQueryRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
