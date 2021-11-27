package com.rambo.exceptions;

/**
 * 代表实例化类时失败的异常。
 *
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 7146764761693834500L;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
