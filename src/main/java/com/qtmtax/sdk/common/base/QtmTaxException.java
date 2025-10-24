package com.qtmtax.sdk.common.base;

import com.qtmtax.sdk.common.enums.QtmTaxErrorCode;

/**
 * <h1>QtmTaxException</h1>
 *
 * @author Hamm.cn
 */
public class QtmTaxException extends RuntimeException {
    /**
     * 状态码
     */
    private int code = QtmTaxErrorCode.SERVICE_ERROR.getCode();

    /**
     * 获取状态码
     *
     * @return 状态码
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置状态码
     *
     * @param code 状态码
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 异常
     *
     * @param code    状态码
     * @param message 错误信息
     */
    public QtmTaxException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 异常
     *
     * @param message 错误信息
     */
    public QtmTaxException(String message) {
        super(message);
    }
}
