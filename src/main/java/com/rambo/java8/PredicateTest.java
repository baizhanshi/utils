package com.rambo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * predicate 函数编程
 * Created by baizhanshi on 2019/7/23.
 */
public class PredicateTest {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest predicateTest = new PredicateTest();
        //输出大于5的数字
        List<Integer> result = predicateTest.conditionFilter(list, integer -> integer > 5);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出大于等于5的数字
        result = predicateTest.conditionFilter(list, integer -> integer >= 5);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出小于8的数字
        result = predicateTest.conditionFilter(list, integer -> integer < 8);
        result.forEach(System.out::println);
        System.out.println("-------");
        //输出所有数字
        result = predicateTest.conditionFilter(list, integer -> true);
        result.forEach(System.out::println);
        System.out.println("-------");

        //大于5并且是偶数
        result = predicateTest.conditionFilterAnd(list, integer -> integer > 5, integer1 -> integer1 % 2 == 0);
        result.forEach(System.out::println);//6 8 10
        System.out.println("-------");

        //大于5或者是偶数
        result = predicateTest.conditionFilterOr(list, integer -> integer > 5, integer1 -> integer1 % 2 == 0);
        result.forEach(System.out::println);//2 4 6 7 8 9 10
        System.out.println("-------");

        //条件取反
        result = predicateTest.conditionFilterNegate(list,integer2 -> integer2 > 5);
        result.forEach(System.out::println);// 1 2 3 4 5
        System.out.println("-------");
    }

    //高度抽象的方法定义，复用性高
    public List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
    //根据传入的参数取反 negate
    public List<Integer> conditionFilterNegate(List<Integer> list, Predicate<Integer> predicate){
        return list.stream().filter(predicate.negate()).collect(Collectors.toList());
    }
    //根据传入的两个条件取交集 and
    public List<Integer> conditionFilterAnd(List<Integer> list, Predicate<Integer> predicate,Predicate<Integer> predicate2){
        return list.stream().filter(predicate.and(predicate2)).collect(Collectors.toList());
    }
    //根据传入的两个条件取并集 or
    public List<Integer> conditionFilterOr(List<Integer> list, Predicate<Integer> predicate,Predicate<Integer> predicate2){
        return list.stream().filter(predicate.or(predicate2)).collect(Collectors.toList());
    }
}
