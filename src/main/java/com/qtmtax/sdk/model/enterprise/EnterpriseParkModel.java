package com.qtmtax.sdk.model.enterprise;

import com.qtmtax.sdk.model.enterprise.park.ParkModel;

/**
 * <h1>企业园区模型</h1>
 *
 * @author zhoul
 */
public class EnterpriseParkModel {
    /**
     * <h2>企业园区ID</h2>
     */
    private Long id;

    /**
     * <h2>服务费率</h2>
     */
    private Double serviceRatio;

    /**
     * <h2>当前余额</h2>
     */
    private Double balance;

    /**
     * <h2>园区信息</h2>
     */
    private ParkModel park;

    /**
     * <h2>企业园区ID</h2>
     *
     * @return 企业园区ID
     */
    public Long getId() {
        return id;
    }

    /**
     * <h2>企业园区ID</h2>
     *
     * @param id 企业园区ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <h2>服务费率</h2>
     *
     * @return 服务费率
     */
    public Double getServiceRatio() {
        return serviceRatio;
    }

    /**
     * <h2>服务费率</h2>
     *
     * @param serviceRatio 服务费率
     */
    public void setServiceRatio(Double serviceRatio) {
        this.serviceRatio = serviceRatio;
    }

    /**
     * <h2>当前余额</h2>
     *
     * @return 当前余额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * <h2>当前余额</h2>
     *
     * @param balance 当前余额
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * <h2>园区信息</h2>
     *
     * @return 园区信息
     */
    public ParkModel getPark() {
        return park;
    }

    /**
     * <h2>园区信息</h2>
     *
     * @param park 园区信息
     */
    public void setPark(ParkModel park) {
        this.park = park;
    }
}
