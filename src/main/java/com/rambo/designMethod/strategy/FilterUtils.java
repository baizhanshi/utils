package com.rambo.designMethod.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 抽象化List
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/20 10:14
 */
public class FilterUtils {

    //映入类型参数T
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
