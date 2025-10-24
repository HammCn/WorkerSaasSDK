package com.qtmtax.sdk.model.park.enterprise.query;

import com.qtmtax.sdk.common.base.AbstractResponse;
import com.qtmtax.sdk.common.base.QtmTaxJson;
import com.qtmtax.sdk.model.enterprise.park.EnterpriseParkModel;

/**
 * <h1>查询企业园区详情响应模型</h1>
 *
 * @author zhoul
 */
public class ParkEnterpriseQueryResponse extends AbstractResponse<ParkEnterpriseQueryResponse> {
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
    public ParkEnterpriseQueryResponse parseData(String data) {
        return this.setEnterprisePark(QtmTaxJson.parse(data, EnterpriseParkModel.class));
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
    public ParkEnterpriseQueryResponse setEnterprisePark(EnterpriseParkModel enterprisePark) {
        this.enterprisePark = enterprisePark;
        return this;
    }
}
