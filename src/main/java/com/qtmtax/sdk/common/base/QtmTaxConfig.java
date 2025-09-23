package com.qtmtax.sdk.common.base;

import com.qtmtax.sdk.common.enums.QuantumTaxArithmetic;

/**
 * <h1>QtmTaxConfig</h1>
 *
 * @author Hamm.cn
 * @apiNote 可在管理后台 -> 开放能力 -> 我的应用 中创建并获取相关配置
 */
public class QtmTaxConfig {
    /**
     * <h2>禁止外部实例化</h2>
     */
    private QtmTaxConfig() {

    }

    /**
     * <h2>网关地址</h2>
     */
    private String gateway = QtmTaxConstant.GATEWAY_PRODUCTION;

    /**
     * <h2>AppKey</h2>
     */
    private String appKey;

    /**
     * <h2>AppSecret</h2>
     */
    private String appSecret;

    /**
     * <h2>加密方式</h2>
     */
    private QuantumTaxArithmetic arithmetic = QuantumTaxArithmetic.AES;

    /**
     * <h2>公钥</h2>
     */
    private String publicKey;

    /**
     * <h2>获取AppKey</h2>
     *
     * @return AppKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * <h2>设置AppKey</h2>
     *
     * @param appKey AppKey
     * @return 当前实例
     */
    public QtmTaxConfig setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    /**
     * <h2>获取AppSecret</h2>
     *
     * @return AppSecret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * <h2>设置AppSecret</h2>
     *
     * @param appSecret AppSecret
     * @return 当前实例
     */
    public QtmTaxConfig setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    /**
     * <h2>获取加密方式</h2>
     *
     * @return 加密方式
     */
    public QuantumTaxArithmetic getArithmetic() {
        return arithmetic;
    }

    /**
     * <h2>设置加密方式</h2>
     *
     * @param arithmetic 加密方式
     * @return 当前实例
     */
    public QtmTaxConfig setArithmetic(QuantumTaxArithmetic arithmetic) {
        this.arithmetic = arithmetic;
        return this;
    }

    /**
     * <h2>获取公钥</h2>
     *
     * @return 公钥
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * <h2>设置公钥</h2>
     *
     * @param publicKey 公钥
     * @return 当前实例
     */
    public QtmTaxConfig setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * <h2>创建当前实例</h2>
     *
     * @return 创建一个当前实例
     */
    public static QtmTaxConfig create() {
        return new QtmTaxConfig();
    }

    /**
     * <h2>获取网关地址</h2>
     *
     * @return 网关地址
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * <h2>设置网关地址</h2>
     *
     * @param gateway 网关地址
     * @return 当前实例
     */
    public QtmTaxConfig setGateway(String gateway) {
        this.gateway = gateway;
        return this;
    }

    /**
     * <h2>调试模式</h2>
     */
    private boolean debug = true;

    /**
     * <h2>是否调试模式</h2>
     *
     * @return 调试模式
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * <h2>设置调试模式</h2>
     *
     * @param debug 调试模式
     * @return 当前实例
     */
    public QtmTaxConfig setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }
}
