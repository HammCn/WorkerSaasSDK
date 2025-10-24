package com.workersaas.sdk.model.tax.calc;

import com.workersaas.sdk.common.base.AbstractRequest;

/**
 * <h1>订单创建请求模型</h1>
 *
 * @author Hamm.cn
 */
public class TaxCalcRequest extends AbstractRequest<TaxCalcResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "tax/calc";
    }

    /**
     * 证件号
     */
    private String idCard;

    /**
     * 操作金额
     */
    private Double balance;

    /**
     * 是否是企事业承担
     */
    private Boolean isEnterpriseTax = false;

    /**
     * 证件号
     *
     * @return 证件号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置证件号
     *
     * @param idCard 证件号
     * @return 当前实例
     */
    public TaxCalcRequest setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    /**
     * 操作金额
     *
     * @return 操作金额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * 设置操作金额
     *
     * @param balance 操作金额
     * @return 当前实例
     */
    public TaxCalcRequest setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public TaxCalcRequest setIsEnterpriseTax(Boolean enterpriseTax) {
        isEnterpriseTax = enterpriseTax;
        return this;
    }

    public Boolean getIsEnterpriseTax() {
        return isEnterpriseTax;
    }
}

