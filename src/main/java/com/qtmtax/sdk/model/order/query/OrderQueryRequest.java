package com.qtmtax.sdk.model.order.query;

import com.qtmtax.sdk.common.base.AbstractRequest;

/**
 * <h1>订单查询请求模型</h1>
 *
 * @author Hamm.cn
 */
public class OrderQueryRequest extends AbstractRequest<OrderQueryResponse> {
    /**
     * <h2>API地址</h2>
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "order/query";
    }

    /**
     * <h2>外部订单号</h2>
     */
    private String outerTradeNo;

    /**
     * <h2>外部订单号</h2>
     *
     * @return 外部订单号
     */
    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    /**
     * <h2>设置外部订单号</h2>
     *
     * @param outerTradeNo 外部订单号
     * @return 当前实例
     */
    public OrderQueryRequest setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
        return this;
    }
}

