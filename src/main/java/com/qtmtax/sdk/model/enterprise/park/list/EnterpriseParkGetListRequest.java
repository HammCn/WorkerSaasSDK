package com.qtmtax.sdk.model.enterprise.park.list;

import com.qtmtax.sdk.common.base.AbstractRequest;

/**
 * <h1>获取企业园区列表请求模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseParkGetListRequest extends AbstractRequest<EnterpriseParkGetListResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "enterprisePark/getList";
    }
}
