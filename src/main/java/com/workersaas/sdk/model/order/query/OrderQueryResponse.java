package com.workersaas.sdk.model.order.query;

import com.workersaas.sdk.common.base.AbstractResponse;
import com.workersaas.sdk.common.base.Json;
import com.workersaas.sdk.model.order.OrderModel;

/**
 * <h1>查询发放订单响应模型</h1>
 *
 * @author Hamm.cn
 */
public class OrderQueryResponse extends AbstractResponse<OrderQueryResponse> {
    /**
     * 订单模型
     */
    private OrderModel order;

    /**
     * 解析数据
     *
     * @param data 解密后的data数据
     */
    @Override
    public OrderQueryResponse parseData(String data) {
        return this.setOrder(Json.parse(data, OrderModel.class));
    }

    /**
     * 获取订单模型
     *
     * @return 订单模型
     */
    public OrderModel getOrder() {
        return order;
    }

    /**
     * 设置订单模型
     *
     * @param order 订单模型
     * @return 当前实例
     */
    public OrderQueryResponse setOrder(OrderModel order) {
        this.order = order;
        return this;
    }
}
