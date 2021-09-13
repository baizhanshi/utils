package com.rambo.excel;

import java.util.Collection;

/**
 * @author baizhanshi
 * @version 1.0.0
 * @description 对象工具类
 */
public class ObjectUtils {

    public static boolean isEmpty(Collection<?> c){
        return c == null || c.isEmpty();
    }

    public static boolean isEmpty(Object[] objs){
        return objs == null || objs.length <= 0;
    }
}