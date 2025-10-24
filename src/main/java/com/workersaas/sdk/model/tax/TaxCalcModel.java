package com.workersaas.sdk.model.tax;

/**
 * <h1>税额计算模型</h1>
 *
 * @author zhoul
 */
public class TaxCalcModel {
    /**
     * 税额
     */
    private Double tax;

    /**
     * 增值税
     */
    private Double vatTax;

    /**
     * 附加增值税
     */
    private Double additionalTax;

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getAdditionalTax() {
        return additionalTax;
    }

    public void setAdditionalTax(Double additionalTax) {
        this.additionalTax = additionalTax;
    }

    public void setVatTax(Double vatTax) {
        this.vatTax = vatTax;
    }

    public Double getVatTax() {
        return vatTax;
    }
}
