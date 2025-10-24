package com.qtmtax.sdk.model.tax.calc;

import com.qtmtax.sdk.common.base.AbstractResponse;
import com.qtmtax.sdk.common.base.QtmTaxJson;
import com.qtmtax.sdk.model.tax.TaxCalcModel;

/**
 * <h1>创建发放订单响应模型</h1>
 *
 * @author Hamm.cn
 */
public class TaxCalcResponse extends AbstractResponse<TaxCalcResponse> {
    /**
     * 计算模型
     */
    private TaxCalcModel taxCalc;

    /**
     * 解析数据
     *
     * @param data 解密后的data数据
     */
    @Override
    public TaxCalcResponse parseData(String data) {
        return this.setTaxCalc(QtmTaxJson.parse(data, TaxCalcModel.class));
    }

    /**
     * 获取计算模型
     *
     * @return 计算模型
     */
    public TaxCalcModel getTaxCalc() {
        return taxCalc;
    }

    /**
     * 设置计算模型
     *
     * @param taxCalc 计算模型
     * @return 当前实例
     */
    public TaxCalcResponse setTaxCalc(TaxCalcModel taxCalc) {
        this.taxCalc = taxCalc;
        return this;
    }
}
