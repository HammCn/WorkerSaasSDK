package com.qtmtax.sdk.common.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <h1>QuantumTaxJson</h1>
 *
 * @param <R> 响应模型
 * @author Hamm.cn
 */
public class QuantumTaxJson<R extends QuantumTaxJson<R>> {
    /**
     * <h2>错误代码</h2>
     */
    private int code;

    /**
     * <h2>错误信息</h2>
     */
    private String message;

    /**
     * <h2>响应数据</h2>
     */
    private String data;

    /**
     * <h2>获取错误代码</h2>
     *
     * @return 错误代码
     */
    public int getCode() {
        return code;
    }

    /**
     * <h2>设置错误代码</h2>
     *
     * @param code 错误代码
     * @return 当前实例
     */
    public QuantumTaxJson<R> setCode(int code) {
        this.code = code;
        return this;
    }

    /**
     * <h2>获取错误信息</h2>
     *
     * @return 错误信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * <h2>设置错误信息</h2>
     *
     * @param message 错误信息
     * @return 当前实例
     */
    public QuantumTaxJson<R> setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * <h2>获取响应数据</h2>
     *
     * @return 响应数据
     */
    public String getData() {
        return data;
    }

    /**
     * <h2>设置响应数据</h2>
     *
     * @param data 响应数据
     * @return 当前实例
     */
    public QuantumTaxJson<R> setData(String data) {
        this.data = data;
        return this;
    }

    private static ObjectMapper objectMapper;

    /**
     * <h2>Json反序列化到指定类</h2>
     *
     * @param json  字符串
     * @param clazz 目标类
     * @param <E>   目标类
     * @return 目标类的实例
     */
    public static <E> E parse(String json, Class<E> clazz) {
        try {
            return getObjectMapper().readValue(json, clazz);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * <h2>Json反序列化到指定类</h2>
     *
     * @param json  字符串
     * @param clazz 目标类
     * @param <E>   目标类
     * @return 目标类的实例
     */
    public static <E> List<E> parseList(String json, Class<? extends E[]> clazz) {
        try {
            return Arrays.asList(getObjectMapper().readValue(json, clazz));
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * <h2>Json序列化到字符串</h2>
     *
     * @param object 对象
     * @return 字符串
     */
    public static String toString(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <h2>获取一个配置后的ObjectMapper</h2>
     *
     * @return ObjectMapper
     */
    private static ObjectMapper getObjectMapper() {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
            // 忽略未声明的属性
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            // 忽略值为null的属性
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            // 忽略没有属性的类
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        }
        return objectMapper;
    }
}
