package com.qtmtax.sdk.model.order.create;

import com.qtmtax.sdk.common.base.AbstractResponse;
import com.qtmtax.sdk.common.base.QuantumTaxJson;
import com.qtmtax.sdk.model.order.OrderModel;

/**
 * <h1>创建发放订单响应模型</h1>
 *
 * @author Hamm.cn
 */
public class OrderCreateResponse extends AbstractResponse<OrderCreateResponse> {
    /**
     * <h2>订单模型</h2>
     */
    private OrderModel order;

    /**
     * <h2>解析数据</h2>
     *
     * @param data 解密后的data数据
     */
    @Override
    public OrderCreateResponse parseData(String data) {
        return this.setOrder(QuantumTaxJson.parse(data, OrderModel.class));
    }

    /**
     * <h2>获取订单模型</h2>
     *
     * @return 订单模型
     */
    public OrderModel getOrder() {
        return order;
    }

    /**
     * <h2>设置订单模型</h2>
     *
     * @param order 订单模型
     * @return 当前实例
     */
    public OrderCreateResponse setOrder(OrderModel order) {
        this.order = order;
        return this;
    }
}
