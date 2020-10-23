package com.rambo.designMethod.strategy;

import com.rambo.java8.Apple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数化类似于策略模式
 * 
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/20 10:18
 */
public class TestStrategy {
    public static void main(String[] args) {

        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 = new Apple(1, "苹果", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(4, "苹果", new BigDecimal("1.35"), 20);
        appleList.add(apple1);
        appleList.add(apple12);

        List<Apple> colourApples = FilterUtils.filter(appleList, new AppleGreenColorPredicate());
        System.out.println(colourApples.toString());
    }
}
