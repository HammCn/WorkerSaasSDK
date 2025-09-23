package com.qtmtax.sdk.model.order.create;

import com.qtmtax.sdk.common.base.AbstractRequest;
import com.qtmtax.sdk.enums.IdCardType;

/**
 * <h1>订单创建请求模型</h1>
 *
 * @author Hamm.cn
 */
public class OrderCreateRequest extends AbstractRequest<OrderCreateResponse> {
    /**
     * <h2>API地址</h2>
     *
     * @return API地址
     */
    @Override
    protected String getApiUrl() {
        return "order/create";
    }

    /**
     * <h2>外部订单号</h2>
     */
    private String outerTradeNo;

    /**
     * <h2>真实姓名</h2>
     */
    private String realName;

    /**
     * <h2>手机号</h2>
     */
    private String phone;

    /**
     * <h2>证件号</h2>
     */
    private String idCard;

    /**
     * <h2>证件类型</h2>
     */
    private Integer idCardType = IdCardType.CHINA_ID_CARD.getKey();

    /**
     * <h2>支付账号</h2>
     */
    private String payAccount;

    /**
     * <h2>银行摘要</h2>
     */
    private String reason;

    /**
     * <h2>业务账号</h2>
     */
    private String bizAccount;

    /**
     * <h2>操作金额</h2>
     */
    private Double balance;

    /**
     * <h2>任务ID</h2>
     */
    private Long taskId;

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
    public OrderCreateRequest setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
        return this;
    }

    /**
     * <h2>真实姓名</h2>
     *
     * @return 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * <h2>设置真实姓名</h2>
     *
     * @param realName 真实姓名
     * @return 当前实例
     */
    public OrderCreateRequest setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    /**
     * <h2>手机号</h2>
     *
     * @return 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * <h2>设置手机号</h2>
     *
     * @param phone 手机号
     * @return 当前实例
     */
    public OrderCreateRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * <h2>证件号</h2>
     *
     * @return 证件号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * <h2>设置证件号</h2>
     *
     * @param idCard 证件号
     * @return 当前实例
     */
    public OrderCreateRequest setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    /**
     * <h2>证件类型</h2>
     *
     * @return 证件类型
     */
    public Integer getIdCardType() {
        return idCardType;
    }

    /**
     * <h2>设置证件类型</h2>
     *
     * @param idCardType 证件类型
     * @return 当前实例
     */
    public OrderCreateRequest setIdCardType(IdCardType idCardType) {
        this.idCardType = idCardType.getKey();
        return this;
    }

    /**
     * <h2>支付账号</h2>
     *
     * @return 支付账号
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * <h2>设置支付账号</h2>
     *
     * @param payAccount 支付账号
     * @return 当前实例
     */
    public OrderCreateRequest setPayAccount(String payAccount) {
        this.payAccount = payAccount;
        return this;
    }

    /**
     * <h2>银行摘要</h2>
     */
    public String getReason() {
        return reason;
    }

    /**
     * <h2>设置银行摘要</h2>
     *
     * @param reason 银行摘要
     * @return 当前实例
     */
    public OrderCreateRequest setReason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * <h2>业务账号</h2>
     *
     * @return 业务账号
     */
    public String getBizAccount() {
        return bizAccount;
    }

    /**
     * <h2>设置业务账号</h2>
     *
     * @param bizAccount 业务账号
     * @return 当前实例
     */
    public OrderCreateRequest setBizAccount(String bizAccount) {
        this.bizAccount = bizAccount;
        return this;
    }

    /**
     * <h2>操作金额</h2>
     *
     * @return 操作金额
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * <h2>设置操作金额</h2>
     *
     * @param balance 操作金额
     * @return 当前实例
     */
    public OrderCreateRequest setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    /**
     * <h2>任务ID</h2>
     *
     * @return 任务ID
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * <h2>设置任务ID</h2>
     *
     * @param taskId 任务ID
     * @return 当前实例
     */
    public OrderCreateRequest setTaskId(Long taskId) {
        this.taskId = taskId;
        return this;
    }
}

