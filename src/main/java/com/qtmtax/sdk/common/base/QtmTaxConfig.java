package com.qtmtax.sdk.common.base;

import com.qtmtax.sdk.common.enums.QtmTaxArithmetic;

/**
 * <h1>QtmTaxConfig</h1>
 *
 * @author Hamm.cn
 * @apiNote 可在管理后台 -> 开放能力 -> 我的应用 中创建并获取相关配置
 */
public class QtmTaxConfig {
    /**
     * 禁止外部实例化
     */
    private QtmTaxConfig() {

    }

    /**
     * 网关地址
     */
    private String gateway = QtmTaxConstant.GATEWAY_PRODUCTION;

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
    private QtmTaxArithmetic arithmetic = QtmTaxArithmetic.AES;

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
    public QtmTaxConfig setAppKey(String appKey) {
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
    public QtmTaxConfig setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    /**
     * 获取加密方式
     *
     * @return 加密方式
     */
    public QtmTaxArithmetic getArithmetic() {
        return arithmetic;
    }

    /**
     * 设置加密方式
     *
     * @param arithmetic 加密方式
     * @return 当前实例
     */
    public QtmTaxConfig setArithmetic(QtmTaxArithmetic arithmetic) {
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
    public QtmTaxConfig setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * 创建当前实例
     *
     * @return 创建一个当前实例
     */
    public static QtmTaxConfig create() {
        return new QtmTaxConfig();
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
    public QtmTaxConfig setGateway(String gateway) {
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
    public QtmTaxConfig setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }
}
