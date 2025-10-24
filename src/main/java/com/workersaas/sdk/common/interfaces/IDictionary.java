package com.workersaas.sdk.common.interfaces;

/**
 * <h1>枚举字典标准接口</h1>
 *
 * @author Hamm.cn
 */
public interface IDictionary {
    /**
     * 获取枚举的key
     *
     * @return key
     */
    int getKey();

    /**
     * 获取枚举的描述
     *
     * @return 描述
     */
    String getLabel();

    /**
     * 判断Key是否相等
     *
     * @param key 被判断的Key
     * @return 对比结果
     */
    default boolean equalsKey(int key) {
        return this.getKey() == key;
    }

    /**
     * 判断Key是否不相等
     *
     * @param key 被判断的Key
     * @return 对比结果
     */
    default boolean notEqualsKey(int key) {
        return !equalsKey(key);
    }
}
