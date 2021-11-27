package com.rambo.java8.ifAndElse;

/**
 * @author ：BAIZHANSHI998
 * @date ：Created in 2021-11-26 8:56
 */
@FunctionalInterface
public interface ThrowExceptionFunction {
    /**
     * 抛出异常信息
     *
     * @param message 异常信息
     * @return void
     **/
    void throwMessage(String message);
}
