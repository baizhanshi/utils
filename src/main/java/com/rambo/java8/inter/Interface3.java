package com.rambo.java8.inter;

/**
 * @author baizhanshi on 2019/4/21.
 */
public interface Interface3 {

    /**
     * 接口中直接声明静态方法
     *
     * 接口名.方法名
     * @return
     */
    static String send(){
        return "interface static method";
    }
}
