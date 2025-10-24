package com.workersaas.sdk.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * <h1>AesUtil</h1>
 *
 * @author Hamm.cn
 */
public class AesUtil {
    /**
     * AES
     */
    private static final String AES = "AES";

    /**
     * AES/CBC/PKCS5Padding
     */
    private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";

    /**
     * 密钥
     */
    private byte[] key;

    /**
     * 偏移向量
     */
    private static final byte[] IV = "0000000000000000".getBytes(UTF_8);

    /**
     * 算法
     */
    private String algorithm = AES_CBC_PKCS5_PADDING;

    /**
     * 设置算法
     *
     * @param algorithm 算法
     * @return 当前实例
     */
    public AesUtil setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    /**
     * 设置密钥
     *
     * @param key 密钥
     * @return 当前实例
     */
    public AesUtil setKey(String key) {
        this.key = Base64.getDecoder().decode(key);
        return this;
    }

    /**
     * 加密
     *
     * @param source 待加密的内容
     * @return 加密后的内容
     */
    public final String encrypt(String source) {
        try {
            byte[] bytes = source.getBytes(UTF_8);
            Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
            return Base64.getEncoder().encodeToString(cipher.doFinal(bytes));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     *
     * @param content 加密后的内容
     * @return 解密后的内容
     */
    public final String decrypt(String content) {
        try {
            Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
            byte[] decodeContent = Base64.getDecoder().decode(content);
            return new String(cipher.doFinal(decodeContent), UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取Cipher
     *
     * @param mode 模式
     * @return Cipher
     */
    private Cipher getCipher(int mode) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, AES);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(mode, secretKeySpec, ivParameterSpec);
            return cipher;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 初始化
     *
     * @return AES
     */
    public static AesUtil create() {
        return new AesUtil();
    }
}
