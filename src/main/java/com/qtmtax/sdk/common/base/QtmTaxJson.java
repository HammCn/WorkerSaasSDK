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
 * <h1>QtmTaxJson</h1>
 *
 * @param <R> 响应模型
 * @author Hamm.cn
 */
public class QtmTaxJson<R extends QtmTaxJson<R>> {
    /**
     * 错误代码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 响应数据
     */
    private String data;

    /**
     * 获取错误代码
     *
     * @return 错误代码
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置错误代码
     *
     * @param code 错误代码
     * @return 当前实例
     */
    public QtmTaxJson<R> setCode(int code) {
        this.code = code;
        return this;
    }

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置错误信息
     *
     * @param message 错误信息
     * @return 当前实例
     */
    public QtmTaxJson<R> setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 获取响应数据
     *
     * @return 响应数据
     */
    public String getData() {
        return data;
    }

    /**
     * 设置响应数据
     *
     * @param data 响应数据
     * @return 当前实例
     */
    public QtmTaxJson<R> setData(String data) {
        this.data = data;
        return this;
    }

    private static ObjectMapper objectMapper;

    /**
     * Json反序列化到指定类
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
     * Json反序列化到指定类
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
     * Json序列化到字符串
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
     * 获取一个配置后的ObjectMapper
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
