package com.rambo.java8.ifAndElse;


/**
 * 分支处理接口
 * * @author ：BAIZHANSHI998
 *
 * @date ：Created in 2021-11-26 9:07
 **/
@FunctionalInterface
public interface BranchHandle {

    /**
     * 分支操作
     *
     * @param trueHandle  为true时要进行的操作
     * @param falseHandle 为false时要进行的操作
     * @return void
     **/
    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);

}
