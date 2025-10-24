package com.workersaas.sdk.model.park.enterprise.list;

import com.workersaas.sdk.common.base.AbstractRequest;

/**
 * <h1>获取企业园区列表请求模型</h1>
 *
 * @author zhoul
 */
public class ParkEnterpriseGetListRequest extends AbstractRequest<ParkEnterpriseGetListResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "park/getList";
    }
}
