package com.rambo.designMethod.strategy;

import com.rambo.java8.Apple;

import java.util.function.Predicate;

/**
 * 苹果过滤参数
 * 
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/20 10:16
 */
public class AppleGreenColorPredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getNum() >= 10;
    }
}
