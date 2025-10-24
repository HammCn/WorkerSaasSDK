package com.qtmtax.sdk.common.base;

import java.lang.reflect.ParameterizedType;

/**
 * <h1>AbstractRequest</h1>
 *
 * @param <R> 响应模型
 * @author Hamm.cn
 */
public abstract class AbstractRequest<R extends AbstractResponse<R>> {
    /**
     * API地址
     *
     * @return API地址
     */
    protected abstract String getApiUrl();

    /**
     * 获取响应类
     *
     * @return 类
     */
    Class<R> getResponseClass() {
        //noinspection unchecked
        return (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
