package com.workersaas.sdk.model.order.create;

import com.workersaas.sdk.common.base.AbstractRequest;
import com.workersaas.sdk.enums.IdCardType;

/**
 * <h1>订单创建请求模型</h1>
 *
 * @author Hamm.cn
 */
public class OrderCreateRequest extends AbstractRequest<OrderCreateResponse> {
    /**
     * API地址
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "order/create";
    }

    /**
     * 外部订单号
     */
    private String outerTradeNo;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 证件号
     */
    private String idCard;

    /**
     * 通知地址
     */
    private String notifyUrl;

    /**
     * 扩展字段
     */
    private String extension;

    /**
     * 证件类型
     */
    private Integer idCardType = IdCardType.CHINA_ID_CARD.getKey();

    /**
     * 支付账号
     */
    private String payAccount;

    /**
     * 银行摘要
     */
    private String reason;

    /**
     * 业务账号
     */
    private String bizAccount;

    /**
     * 操作金额
     */
    private Double balance;

    /**
     * 任务ID
     */
    private Long taskId;

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
    public OrderCreateRequest setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
        return this;
    }

    /**
     * 真实姓名
     *
     * @return 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     * @return 当前实例
     */
    public OrderCreateRequest setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    /**
     * 手机号
     *
     * @return 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     * @return 当前实例
     */
    public OrderCreateRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

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
    public OrderCreateRequest setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    /**
     * 证件类型
     *
     * @return 证件类型
     */
    public Integer getIdCardType() {
        return idCardType;
    }

    /**
     * 设置证件类型
     *
     * @param idCardType 证件类型
     * @return 当前实例
     */
    public OrderCreateRequest setIdCardType(IdCardType idCardType) {
        this.idCardType = idCardType.getKey();
        return this;
    }

    /**
     * 支付账号
     *
     * @return 支付账号
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * 设置支付账号
     *
     * @param payAccount 支付账号
     * @return 当前实例
     */
    public OrderCreateRequest setPayAccount(String payAccount) {
        this.payAccount = payAccount;
        return this;
    }

    /**
     * 银行摘要
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置银行摘要
     *
     * @param reason 银行摘要
     * @return 当前实例
     */
    public OrderCreateRequest setReason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * 业务账号
     *
     * @return 业务账号
     */
    public String getBizAccount() {
        return bizAccount;
    }

    /**
     * 设置业务账号
     *
     * @param bizAccount 业务账号
     * @return 当前实例
     */
    public OrderCreateRequest setBizAccount(String bizAccount) {
        this.bizAccount = bizAccount;
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
    public OrderCreateRequest setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    /**
     * 任务ID
     *
     * @return 任务ID
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 设置任务ID
     *
     * @param taskId 任务ID
     * @return 当前实例
     */
    public OrderCreateRequest setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderCreateRequest setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public OrderCreateRequest setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
        return this;
    }

    public OrderCreateRequest setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }
}

