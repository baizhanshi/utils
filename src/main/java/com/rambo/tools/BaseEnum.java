
package com.rambo.tools;

/**
 * 枚举类的帮助类
 * 
 * @author baizhanshi
 */
public interface BaseEnum<C, V, D> {

    C getCode();

    V getValue();

    D getDesc();

}
