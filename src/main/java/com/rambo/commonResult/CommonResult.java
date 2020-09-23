package com.rambo.commonResult;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/9/21 15:25
 */
@Data
public final class CommonResult<T>{

    private static final long serialVersionUID = 7092611880189329094L;

    private int               status           = 1;

    private String            errorCode;

    private String            errorMsg;

    private T                 resultBody;

    public CommonResult() {
    }

    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }
}
