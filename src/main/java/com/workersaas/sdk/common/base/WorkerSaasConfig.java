package com.workersaas.sdk.common.base;

import com.workersaas.sdk.common.enums.WorkerSaasArithmetic;

/**
 * <h1>配置信息</h1>
 *
 * @author Hamm.cn
 * @apiNote 可在管理后台 -> 开放能力 -> 我的应用 中创建并获取相关配置
 */
public class WorkerSaasConfig {
    /**
     * 禁止外部实例化
     */
    private WorkerSaasConfig() {

    }

    /**
     * 网关地址
     */
    private String gateway = WorkerSaasConstant.GATEWAY_PRODUCTION;

    /**
     * AppKey
     */
    private String appKey;

    /**
     * AppSecret
     */
    private String appSecret;

    /**
     * 加密方式
     */
    private WorkerSaasArithmetic arithmetic = WorkerSaasArithmetic.AES;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 获取AppKey
     *
     * @return AppKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * 设置AppKey
     *
     * @param appKey AppKey
     * @return 当前实例
     */
    public WorkerSaasConfig setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    /**
     * 获取AppSecret
     *
     * @return AppSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * 设置AppSecret
     *
     * @param appSecret AppSecret
     * @return 当前实例
     */
    public WorkerSaasConfig setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    /**
     * 获取加密方式
     *
     * @return 加密方式
     */
    public WorkerSaasArithmetic getArithmetic() {
        return arithmetic;
    }

    /**
     * 设置加密方式
     *
     * @param arithmetic 加密方式
     * @return 当前实例
     */
    public WorkerSaasConfig setArithmetic(WorkerSaasArithmetic arithmetic) {
        this.arithmetic = arithmetic;
        return this;
    }

    /**
     * 获取公钥
     *
     * @return 公钥
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * 设置公钥
     *
     * @param publicKey 公钥
     * @return 当前实例
     */
    public WorkerSaasConfig setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * 创建当前实例
     *
     * @return 创建一个当前实例
     */
    public static WorkerSaasConfig create() {
        return new WorkerSaasConfig();
    }

    /**
     * 获取网关地址
     *
     * @return 网关地址
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * 设置网关地址
     *
     * @param gateway 网关地址
     * @return 当前实例
     */
    public WorkerSaasConfig setGateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    /**
     * 调试模式
     */
    private boolean debug = true;

    /**
     * 是否调试模式
     *
     * @return 调试模式
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * 设置调试模式
     *
     * @param debug 调试模式
     * @return 当前实例
     */
    public WorkerSaasConfig setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }
}
