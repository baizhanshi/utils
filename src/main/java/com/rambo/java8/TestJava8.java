package com.rambo.java8;

import com.google.common.collect.Lists;
import com.rambo.java8.inter.Student;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java 8 流工作模式
 * 
 * @author baizhanshi on 2018/11/1.
 */
public class TestJava8 {
    public static void main(String[] args) {

        List<Apple> appleList1 = new ArrayList<>();//存放apple对象集合
        List<Apple> appleList2 = new ArrayList<>();//存放apple对象集合
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(4, "苹果1", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList1.add(apple1);
        appleList1.add(apple12);
        appleList2.add(apple2);
        appleList2.add(apple3);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        //并行
        List<Integer> idParalleList = appleList.parallelStream().filter(a -> a.getName().equals("苹果1"))
                .sorted(Comparator.comparing(Apple::getId).reversed()).map(a -> a.getId()).collect(Collectors.toList());

        System.out.println("id集合：" + idParalleList);
        //flatmap
        Stream<List<Apple>> streamList = Stream.of(appleList1, appleList2);

        Map<Integer, Apple> newFlatMap = streamList.flatMap(a -> a.stream())
                .collect(Collectors.toMap(Apple::getId, apple -> apple));

        System.out.println("flatMap:" + newFlatMap.toString());

        //1、list转map,value 值是一个对象但是可以取其中一个对象
        Map<Integer, String> appleMapOnly = appleList.stream().collect(Collectors.toMap(Apple::getId, Apple::getName));
        System.out.println(appleMapOnly.toString());

        System.out.println("====================================");

        //1、list转map,value 值是一个对象
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getNum, apple -> apple));
        System.out.println(appleMap.toString());

        System.out.println("-------------------------------------");

        //1、list转map,value 值是一个集合o
        Map<Integer, List<Apple>> appleMapList = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println(appleMapList.toString());

        System.out.println("也可以这样,第二种写法适合集合对象转换的情况*****************");
        //2、分组,value 值是一个集合
        Map<Integer, List<Apple>> appleMapListMoney = appleList.stream().collect(Collectors.groupingBy(Apple::getId,
                TreeMap::new, Collectors.mapping(apple -> apple, Collectors.toList())));
        System.out.println(appleMapListMoney.toString());

        System.out.println("-------------------------------------");
        //3、filter 过滤器
        long count = appleList.stream().filter(apple -> apple.getName().equals("香蕉")).count();

        System.out.println("名字等于香蕉的数量：" + count);

        System.out.println("-------------------------------------");

        //4、求和
        //计算 总金额
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:" + totalMoney); //totalMoney:17.48

        //计算 数量
        int sum = appleList.stream().mapToInt(Apple::getNum).sum();
        System.err.println("sum:" + sum); //sum:100

        System.out.println("-------------------------------------");

        //5.获取所有的id集合(去重以后的)
        Set<Integer> idSet = appleList.stream().map(a -> a.getId()).collect(Collectors.toSet());
        List<Integer> idList = appleList.stream().map(a -> a.getId()).distinct().collect(Collectors.toList());
        System.out.println(new ArrayList<>(idSet));
        System.out.println(idList);

        System.out.println("-------------------------------------");

        //6.排序
        List<Apple> sortList = appleList.stream().sorted((a, b) -> -a.getId().compareTo(b.getId()))
                .collect(Collectors.toList());
        List<Apple> sortList2 = appleList.stream().sorted(Comparator.comparing(Apple::getId).reversed())
                .collect(Collectors.toList());

        System.out.println("排序：" + sortList.toString());
        System.out.println("排序：" + sortList2.toString());

        //7.求集合中id最大，最小值
        Integer maxId = appleList.stream().map(Apple::getId).distinct().max((a, b) -> a.compareTo(b)).get();
        System.out.println("最大的id是：" + maxId);

        Integer minId = appleList.stream().map(Apple::getId).distinct().min((a, b) -> a.compareTo(b)).get();
        System.out.println("最小的id是：" + minId);
        //求交集 求并集 求差集
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println("====求交集===");

        List<Integer> list = list1.stream().filter(t -> list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        System.out.println("====求差集===");
        list = list1.stream().filter(t -> !list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        System.out.println("====求并集===");

        list.addAll(list1);
        list.addAll(list2);
        list = list.stream().distinct().collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        //join的使用
        String joinedFirstNames = appleList.stream().map(Apple::getName).collect(Collectors.joining(","));

        System.out.println(joinedFirstNames);
        //根据整个实体对象分组计数
        List<Student> list3 = Arrays.asList(new Student(1, "one", "zhao"), new Student(1, "one", "zhao"),
                new Student(2, "one", "zhao"), new Student(3, "two", "sun"));

        Map<Student, Long> result2 = list3.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result2);

        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        for (int i = 0; i < 6; i++) {
            if (i ==3) {
                continue;
            }
            System.out.println(i);
        }

    }

}
