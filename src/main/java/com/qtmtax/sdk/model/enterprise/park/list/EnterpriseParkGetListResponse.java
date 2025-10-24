package com.qtmtax.sdk.model.enterprise.park.list;

import com.qtmtax.sdk.common.base.AbstractResponse;
import com.qtmtax.sdk.common.base.QtmTaxJson;
import com.qtmtax.sdk.model.enterprise.park.EnterpriseParkModel;

import java.util.List;

/**
 * <h1>获取企业园区列表响应模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseParkGetListResponse extends AbstractResponse<EnterpriseParkGetListResponse> {
    /**
     * 企业可用园区列表
     */
    private List<EnterpriseParkModel> enterpriseParkList;

    /**
     * 解析数据
     *
     * @param data 解密后的data数据
     */
    @Override
    public EnterpriseParkGetListResponse parseData(String data) {
        return this.setEnterpriseParkList(QtmTaxJson.parseList(data, EnterpriseParkModel[].class));
    }

    /**
     * 企业可用园区列表
     *
     * @return 企业可用园区列表
     */
    public List<EnterpriseParkModel> getEnterpriseParkList() {
        return enterpriseParkList;
    }

    /**
     * 设置企业可用园区列表
     *
     * @param enterpriseParkList 企业可用园区列表
     * @return 当前实例
     */
    public EnterpriseParkGetListResponse setEnterpriseParkList(List<EnterpriseParkModel> enterpriseParkList) {
        this.enterpriseParkList = enterpriseParkList;
        return this;
    }
}
