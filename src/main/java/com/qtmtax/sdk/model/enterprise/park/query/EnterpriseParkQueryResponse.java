package com.qtmtax.sdk.model.enterprise.park.query;

import com.qtmtax.sdk.common.base.AbstractResponse;
import com.qtmtax.sdk.common.base.QuantumTaxJson;
import com.qtmtax.sdk.model.enterprise.EnterpriseParkModel;

/**
 * <h1>查询企业园区详情响应模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseParkQueryResponse extends AbstractResponse<EnterpriseParkQueryResponse> {
    /**
     * <h2>企业可用园区</h2>
     */
    private EnterpriseParkModel enterprisePark;

    /**
     * <h2>解析数据</h2>
     *
     * @param data 解密后的data数据
     */
    @Override
    public EnterpriseParkQueryResponse parseData(String data) {
        return this.setEnterprisePark(QuantumTaxJson.parse(data, EnterpriseParkModel.class));
    }

    /**
     * <h2>企业可用园区</h2>
     *
     * @return 企业可用园区
     */
    public EnterpriseParkModel getEnterprisePark() {
        return enterprisePark;
    }

    /**
     * <h2>设置企业可用园区</h2>
     *
     * @param enterprisePark 企业可用园区
     * @return 当前实例
     */
    public EnterpriseParkQueryResponse setEnterprisePark(EnterpriseParkModel enterprisePark) {
        this.enterprisePark = enterprisePark;
        return this;
    }
}
