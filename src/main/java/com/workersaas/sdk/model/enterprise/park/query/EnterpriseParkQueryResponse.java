package com.workersaas.sdk.model.enterprise.park.query;

import com.workersaas.sdk.common.base.AbstractResponse;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.model.enterprise.park.EnterpriseParkModel;

/**
 * <h1>查询企业园区详情响应模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseParkQueryResponse extends AbstractResponse<EnterpriseParkQueryResponse> {
    /**
     * 企业可用园区
     */
    private EnterpriseParkModel enterprisePark;

    /**
     * 解析数据
     *
     * @param data 解密后的data数据
     */
    @Override
    public EnterpriseParkQueryResponse parseData(String data) {
        return this.setEnterprisePark(Json.parse(data, EnterpriseParkModel.class));
    }

    /**
     * 企业可用园区
     *
     * @return 企业可用园区
     */
    public EnterpriseParkModel getEnterprisePark() {
        return enterprisePark;
    }

    /**
     * 设置企业可用园区
     *
     * @param enterprisePark 企业可用园区
     * @return 当前实例
     */
    public EnterpriseParkQueryResponse setEnterprisePark(EnterpriseParkModel enterprisePark) {
        this.enterprisePark = enterprisePark;
        return this;
    }
}
