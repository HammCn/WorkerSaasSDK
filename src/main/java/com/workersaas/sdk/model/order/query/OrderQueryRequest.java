package com.workersaas.sdk.model.order.query;

import com.workersaas.sdk.common.base.AbstractRequest;

/**
 * <h1>订单查询请求模型</h1>
 *
 * @author Hamm.cn
 */
public class OrderQueryRequest extends AbstractRequest<OrderQueryResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "order/query";
    }

    /**
     * 外部订单号
     */
    private String outerTradeNo;

    /**
     * 外部订单号
     *
     * @return 外部订单号
     */
    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    /**
     * 设置外部订单号
     *
     * @param outerTradeNo 外部订单号
     * @return 当前实例
     */
    public OrderQueryRequest setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
        return this;
    }
}

