package com.qtmtax.sdk.model.park.enterprise;

import com.qtmtax.sdk.model.enterprise.EnterpriseModel;

/**
 * <h1>企业园区模型</h1>
 *
 * @author zhoul
 */
public class ParkEnterpriseModel {
    /**
     * 企业园区ID
     */
    private Long id;

    /**
     * 服务费率
     */
    private Double serviceRatio;

    /**
     * 当前余额
     */
    private Double balance;

    /**
     * 园区信息
     */
    private EnterpriseModel enterprise;

    /**
     * 企业园区ID
     *
     * @return 企业园区ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 企业园区ID
     *
     * @param id 企业园区ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 服务费率
     *
     * @return 服务费率
     */
    public Double getServiceRatio() {
        return serviceRatio;
    }

    /**
     * 服务费率
     *
     * @param serviceRatio 服务费率
     */
    public void setServiceRatio(Double serviceRatio) {
        this.serviceRatio = serviceRatio;
    }

    /**
     * 当前余额
     *
     * @return 当前余额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * 当前余额
     *
     * @param balance 当前余额
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * 企业信息
     *
     * @return 企业信息
     */
    public EnterpriseModel getEnterprise() {
        return enterprise;
    }

    /**
     * 企业信息
     *
     * @param enterprise 企业信息
     */
    public void setEnterprise(EnterpriseModel enterprise) {
        this.enterprise = enterprise;
    }
}
