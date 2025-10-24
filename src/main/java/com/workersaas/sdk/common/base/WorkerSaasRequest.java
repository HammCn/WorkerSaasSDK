package com.workersaas.sdk.common.base;

import com.workersaas.sdk.common.util.DebugUtil;
import com.workersaas.sdk.common.util.RandomUtil;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * <h1>请求</h1>
 *
 * @author Hamm.cn
 */
public class WorkerSaasRequest {
    /**
     * AppKey
     */
    private String appKey;

    /**
     * 设置AppKey
     *
     * @param appKey AppKey
     * @return 当前实例
     */
    public final WorkerSaasRequest setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    /**
     * 获取AppKey
     *
     * @return AppKey
     */
    public final String getAppKey() {
        return appKey;
    }

    /**
     * 版本号
     */
    private int version = 10000;

    /**
     * 设置版本号
     *
     * @param version 版本号
     * @return 当前实例
     */
    public final WorkerSaasRequest setVersion(int version) {
        this.version = version;
        return this;
    }

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    public final int getVersion() {
        return version;
    }

    /**
     * 请求毫秒时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 设置请求毫秒时间戳
     *
     * @param timestamp 请求毫秒时间戳
     * @return 当前实例
     */
    public final WorkerSaasRequest setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * 获取请求毫秒时间戳
     *
     * @return 请求毫秒时间戳
     */
    public final long getTimestamp() {
        return timestamp;
    }

    /**
     * 加密后的业务数据
     */
    private String content;

    /**
     * 设置加密后的业务数据
     *
     * @param content 加密后的业务数据
     * @return 当前实例
     */
    public final WorkerSaasRequest setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * 获取加密后的业务数据
     *
     * @return 加密后的业务数据
     */
    public final String getContent() {
        return content;
    }

    /**
     * Nonce
     */
    private String nonce = RandomUtil.randomString();

    /**
     * 设置Nonce
     *
     * @param nonce Nonce
     * @return 当前实例
     */
    public final WorkerSaasRequest setNonce(String nonce) {
        this.nonce = nonce;
        return this;
    }

    /**
     * 获取Nonce
     *
     * @return Nonce
     */
    public final String getNonce() {
        return nonce;
    }

    /**
     * 签名字符串
     */
    private String signature;

    /**
     * 设置签名字符串
     *
     * @param signature 签名字符串
     * @return 当前实例
     */
    public final WorkerSaasRequest setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    /**
     * 获取签名字符串
     *
     * @return 签名字符串
     */
    public final String getSignature() {
        return signature;
    }

    /**
     * 签名
     *
     * @param appSecret AppSecret
     * @return 当前实例
     */
    public final String sign(String appSecret) {
        String[] strings = new String[]{appSecret, getAppKey(), String.valueOf(getVersion()), String.valueOf(getTimestamp()), getNonce(), getContent()};
        final String source = String.join("", strings);
        DebugUtil.show("签名数据", source);
        DebugUtil.show("签名数据(可读)", String.join("  ", strings));
        signature = DigestUtils.sha1Hex(source);
        DebugUtil.show("签名结果", signature);
        return signature;
    }
}
