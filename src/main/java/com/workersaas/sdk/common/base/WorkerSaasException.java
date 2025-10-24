package com.workersaas.sdk.common.base;

import com.workersaas.sdk.common.enums.WorkerSaasErrorCode;

/**
 * <h1>异常</h1>
 *
 * @author Hamm.cn
 */
public class WorkerSaasException extends RuntimeException {
    /**
     * 状态码
     */
    private int code = WorkerSaasErrorCode.SERVICE_ERROR.getCode();

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
    public WorkerSaasException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 异常
     *
     * @param message 错误信息
     */
    public WorkerSaasException(String message) {
        super(message);
    }
}
