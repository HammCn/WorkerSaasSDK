package com.qtmtax.sdk.common.util;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * <h1>RsaUtil</h1>
 *
 * @author Hamm.cn
 */
public class RsaUtil {
    /**
     * 加密算法KEY长度
     */
    private static final int CRYPT_KEY_SIZE = 2048;

    /**
     * 加密方式
     */
    private static final String CRYPT_METHOD = "RSA";

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 初始化
     *
     * @return RSA
     */
    public static RsaUtil create() {
        return new RsaUtil();
    }

    /**
     * 设置公钥
     *
     * @param publicKey 公钥
     * @return 当前实例
     */
    public final RsaUtil setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * 公钥加密
     *
     * @param sourceContent 原文
     * @return 密文
     */
    public final String encrypt(String sourceContent) {
        try {
            int blockSize = CRYPT_KEY_SIZE / 8 - 11;
            PublicKey publicKey = getPublicKey(this.publicKey);
            return encrypt(sourceContent, publicKey, blockSize);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * 公钥解密
     *
     * @param encryptedContent 密文
     * @return 原文
     */
    public final String decrypt(String encryptedContent) {
        try {
            int blockSize = CRYPT_KEY_SIZE / 8;
            PublicKey publicKey = getPublicKey(this.publicKey);
            return decrypt(encryptedContent, publicKey, blockSize);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * 公私钥解密
     *
     * @param encryptedContent 密文
     * @param key              公私钥
     * @param blockSize        分块大小
     * @return 明文
     */
    private String decrypt(String encryptedContent, Key key, int blockSize) throws Exception {
        byte[] srcBytes = Base64.getDecoder().decode(encryptedContent);
        Cipher deCipher;
        deCipher = Cipher.getInstance(CRYPT_METHOD);
        deCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] resultBytes;
        resultBytes = rsaDoFinal(deCipher, srcBytes, blockSize);
        return new String(resultBytes);
    }

    /**
     * 公私钥加密
     *
     * @param sourceContent 明文
     * @param key           公私钥
     * @param blockSize     区块大小
     * @return 密文
     */
    private String encrypt(String sourceContent, Key key, int blockSize) throws Exception {
        byte[] srcBytes = sourceContent.getBytes();
        Cipher cipher;
        cipher = Cipher.getInstance(CRYPT_METHOD);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] resultBytes;
        resultBytes = rsaDoFinal(cipher, srcBytes, blockSize);
        return Base64.getEncoder().encodeToString(resultBytes);
    }

    /**
     * 获取一个公钥
     *
     * @param publicKeyString 公钥字符串
     * @return 公钥
     * @throws Exception 异常
     */
    private PublicKey getPublicKey(String publicKeyString) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(CRYPT_METHOD);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyString));
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

    /**
     * RSA处理方法
     *
     * @param cipher      RSA实例
     * @param sourceBytes 加解密原始数据
     * @param blockSize   分片大小
     * @return 加解密结果
     * @throws Exception 加解密异常
     */
    private byte[] rsaDoFinal(Cipher cipher, byte[] sourceBytes, int blockSize) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int inputLength = sourceBytes.length;
        int currentOffSet = 0;
        byte[] cacheBytes;
        int index = 0;
        // 对数据分段解密
        while (inputLength - currentOffSet > 0) {
            cacheBytes = cipher.doFinal(sourceBytes, currentOffSet, Math.min(inputLength - currentOffSet, blockSize));
            byteArrayOutputStream.write(cacheBytes, 0, cacheBytes.length);
            index++;
            currentOffSet = index * blockSize;
        }
        byte[] data = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return data;
    }
}
