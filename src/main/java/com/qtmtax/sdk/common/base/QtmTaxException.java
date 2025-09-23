package com.qtmtax.sdk.common.base;

import com.qtmtax.sdk.common.enums.QuantumTaxErrorCode;

/**
 * <h1>QtmTaxException</h1>
 *
 * @author Hamm.cn
 */
public class QtmTaxException extends RuntimeException {
    /**
     * <h2>状态码</h2>
     */
    private int code = QuantumTaxErrorCode.SERVICE_ERROR.getCode();

    /**
     * <h2>获取状态码</h2>
     *
     * @return 状态码
     */
    public int getCode() {
        return code;
    }

    /**
     * <h2>设置状态码</h2>
     *
     * @param code 状态码
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * <h2>异常</h2>
     *
     * @param code    状态码
     * @param message 错误信息
     */
    public QtmTaxException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * <h2>异常</h2>
     *
     * @param message 错误信息
     */
    public QtmTaxException(String message) {
        super(message);
    }
}
