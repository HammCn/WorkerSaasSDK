package com.qtmtax.sdk.model.order;

/**
 * <h1>订单状态枚举</h1>
 *
 * @author Hamm.cn
 */
public enum OrderStatus {
    /**
     * 等待确认
     */
    CONFIRMING("等待确认"),

    /**
     * 订单取消
     */
    CANCELED("订单取消"),

    /**
     * 正在支付
     */
    PAYING("正在支付"),

    /**
     * 支付成功
     */
    SUCCESS("支付成功"),

    /**
     * 支付失败
     */
    FAIL("支付失败"),
    ;

    private final String label;

    public String getLabel() {
        return label;
    }

    OrderStatus(String label) {
        this.label = label;
    }
}
