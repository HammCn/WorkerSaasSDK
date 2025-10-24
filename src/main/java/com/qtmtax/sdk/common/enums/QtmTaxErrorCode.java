package com.qtmtax.sdk.common.enums;

/**
 * <h1>错误代码</h1>
 *
 * @author Hamm.cn
 */
public enum QtmTaxErrorCode {
    /**
     * 成功
     */
    SUCCESS(200),

    /**
     * 服务发生异常
     */
    SERVICE_ERROR(500);

    /**
     * 错误代码
     */
    private final int code;

    /**
     * 创建一个错误代码
     *
     * @param code 错误代码
     */
    QtmTaxErrorCode(int code) {
        this.code = code;
    }

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    public int getCode() {
        return code;
    }
}
