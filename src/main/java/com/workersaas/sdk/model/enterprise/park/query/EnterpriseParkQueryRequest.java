package com.workersaas.sdk.model.enterprise.park.query;

import com.workersaas.sdk.common.base.AbstractRequest;

/**
 * <h1>查询企业园区详情请求模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseParkQueryRequest extends AbstractRequest<EnterpriseParkQueryResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "enterprisePark/query";
    }

    /**
     * 企业园区ID
     */
    private Long id;

    /**
     * 企业园区ID
     *
     * @return 企业园区ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置企业园区ID
     *
     * @param id 当前实例
     * @return 当前实例
     */
    public EnterpriseParkQueryRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
