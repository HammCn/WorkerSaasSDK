package com.workersaas.sdk.model.park.enterprise.list;

import com.workersaas.sdk.common.base.AbstractResponse;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.model.park.enterprise.ParkEnterpriseModel;

import java.util.List;

/**
 * <h1>获取企业园区列表响应模型</h1>
 *
 * @author zhoul
 */
public class ParkEnterpriseGetListResponse extends AbstractResponse<ParkEnterpriseGetListResponse> {
    /**
     * 企业可用园区列表
     */
    private List<ParkEnterpriseModel> parkEnterpriseList;

    /**
     * 解析数据
     *
     * @param data 解密后的data数据
     */
    @Override
    public ParkEnterpriseGetListResponse parseData(String data) {
        return this.setParkEnterpriseList(Json.parseList(data, ParkEnterpriseModel[].class));
    }

    /**
     * 企业可用园区列表
     *
     * @return 企业可用园区列表
     */
    public List<ParkEnterpriseModel> getParkEnterpriseList() {
        return parkEnterpriseList;
    }


    /**
     * 设置企业可用园区列表
     *
     * @param parkEnterpriseList 企业可用园区列表
     */
    public ParkEnterpriseGetListResponse setParkEnterpriseList(List<ParkEnterpriseModel> parkEnterpriseList) {
        this.parkEnterpriseList = parkEnterpriseList;
        return this;
    }
}
