package com.rambo.java8;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by baizhanshi on 2019/5/8.
 */
public class TestStream {
    public static void main(String[] args) {
        Arrays.asList("a1", "a2", "a3").stream() // 创建流
                .findFirst() // 找到第一个元素
                .ifPresent(System.out::println);

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        //        names.sort((a, b) -> -a.compareTo(b));

        names = names.stream().sorted().collect(Collectors.toList());

        System.out.println("对数组进行排序" + names.toString());

        //嵌套循环遍历判断属性equals
        Apple apple1 = new Apple(1, "苹果", new BigDecimal("3.25"), 10);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("1.35"), 20);
        Apple apple3 = new Apple(1, "苹果", new BigDecimal("2.89"), 30);
        Apple apple4 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        List<Apple> appleList1 = new ArrayList<>();//存放apple对象集合
        List<Apple> appleList2 = new ArrayList<>();//存放apple对象集合

        appleList1.add(apple1);
        appleList1.add(apple2);
        appleList2.add(apple3);
        appleList2.add(apple4);

        appleList1.forEach(a -> {
            appleList2.stream().filter(b -> (a.getId() + a.getName()).equals(b.getId() + a.getName())).findAny()
                    .ifPresent(b -> {
                        b.setNum(a.getNum());
                        b.setMoney(a.getMoney());
                    });
        });
        System.out.println(appleList1);
        System.out.println(appleList2);

        //map转list
        Map<Integer, String> map = Maps.newHashMap();
        map.put(5, "芒果");
        map.put(6, "葡萄");
        map.put(7, "梨子");

        List<Apple> appleList = map.entrySet().stream().map(e -> new Apple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        System.out.println(appleList.toString());

        appleList1.stream().filter(apple -> apple.getName().equals("苹果")).forEach(app -> app.setName("芭蕉"));

        System.out.println("过滤以后名字设置之后的值：" + appleList1.toString());

    }
}
