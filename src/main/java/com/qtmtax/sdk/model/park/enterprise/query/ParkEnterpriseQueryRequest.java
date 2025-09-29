package com.qtmtax.sdk.model.park.enterprise.query;

import com.qtmtax.sdk.common.base.AbstractRequest;

/**
 * <h1>查询企业园区详情请求模型</h1>
 *
 * @author zhoul
 */
public class ParkEnterpriseQueryRequest extends AbstractRequest<ParkEnterpriseQueryResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "park/query";
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
    public ParkEnterpriseQueryRequest setId(Long id) {
        this.id = id;
        return this;
    }
}
