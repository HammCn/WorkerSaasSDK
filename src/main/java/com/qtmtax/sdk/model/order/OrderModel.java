package com.qtmtax.sdk.model.order;

/**
 * <h1>订单模型</h1>
 *
 * @author zhoul
 */
public class OrderModel {
    /**
     * 订单创建时间
     */
    private Long createTime;

    /**
     * 外部订单号
     */
    private String outerTradeNo;

    /**
     * 支付平台订单号
     */
    private String payOutTradeNo;

    /**
     * 订单号
     */
    private String tradeNo;

    /**
     * 状态
     */
    private String state;

    /**
     * 支付账号
     */
    private String payAccount;

    /**
     * 任务ID
     */
    private Long taskId;

    /**
     * 订单金额
     */
    private Double balance;

    /**
     * 个税
     */
    private Double tax;

    /**
     * 个税
     */
    private Double vatTax;

    /**
     * 附加税
     */
    private Double additionalTax;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 付款时间
     */
    private Long payTime;

    /**
     * 服务费
     */
    private Double serviceBalance;

    /**
     * 扩展字段
     */
    private String extension;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * 订单创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 外部订单号
     */
    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    /**
     * 外部订单号
     *
     * @param outerTradeNo 外部订单号
     */
    public void setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
    }

    /**
     * 订单号
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 订单号
     *
     * @param tradeNo 订单号
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 任务ID
     *
     * @param taskId 任务ID
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 任务ID
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 订单金额
     *
     * @param balance 订单金额
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * 订单金额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * 支付账号
     *
     * @param payAccount 支付账号
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * 支付账号
     */
    public String getPayAccount() {
        return payAccount;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

    public void setVatTax(Double vatTax) {
        this.vatTax = vatTax;
    }

    public Double getVatTax() {
        return vatTax;
    }

    public void setAdditionalTax(Double additionalTax) {
        this.additionalTax = additionalTax;
    }

    public Double getAdditionalTax() {
        return additionalTax;
    }

    public Double getServiceBalance() {
        return serviceBalance;
    }

    public void setServiceBalance(Double serviceBalance) {
        this.serviceBalance = serviceBalance;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPayOutTradeNo() {
        return payOutTradeNo;
    }

    public void setPayOutTradeNo(String payOutTradeNo) {
        this.payOutTradeNo = payOutTradeNo;
    }
}
