package com.rambo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * consumer Created by baizhanshi on 2019/7/23.
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Integer> consumer = (x) -> {
            int num = x * 2;
            System.out.println(num);
        };
        Consumer<Integer> consumer1 = (x) -> {
            int num = x * 3;
            System.out.println(num);
        };
        consumer.andThen(consumer1).accept(10);

        String str = null;
        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.orElseGet(() -> "welcome"));

        System.out.println("------------");
        List<String> list = Arrays.asList("hello", "world", "helloworld");

        List<String> collect = list.stream().map(a -> a.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect.toString());

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));

        List<Integer> collect1 = listStream.flatMap(a -> a.stream()).map(b -> b * b).collect(Collectors.toList());
        System.out.println(collect1.toString());
        //supplier
        Supplier<String> supplier =()->"hello word";
        System.out.println(supplier.get());

        Optional<String> optional1 = Optional.ofNullable(null);
        System.out.println(optional1.isPresent());

    }
}
