package com.qtmtax.sdk.model.order;

/**
 * <h1>订单模型</h1>
 *
 * @author zhoul
 */
public class OrderModel {
    /**
     * <h2>订单创建时间</h2>
     */
    private Long createTime;

    /**
     * <h2>外部订单号</h2>
     */
    private String outerTradeNo;

    /**
     * <h2>订单号</h2>
     */
    private String tradeNo;

    /**
     * <h2>状态</h2>
     */
    private String state;

    /**
     * <h2>订单创建时间</h2>
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * <h2>订单创建时间</h2>
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * <h2>外部订单号</h2>
     */
    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    /**
     * <h2>外部订单号</h2>
     *
     * @param outerTradeNo 外部订单号
     */
    public void setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
    }

    /**
     * <h2>订单号</h2>
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * <h2>订单号</h2>
     *
     * @param tradeNo 订单号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * <h2>状态</h2>
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * <h2>状态</h2>
     */
    public String getState() {
        return state;
    }
}
