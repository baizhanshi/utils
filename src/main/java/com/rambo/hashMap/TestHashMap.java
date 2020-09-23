package com.rambo.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * hashMap 的七种遍历方式
 * @author ：baizhanshi
 * @date ：Created in 2020/5/12 10:53
 */
public class TestHashMap {

    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 1.迭代器 EntrySet 删除安全
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
        System.out.println("------------");

        //2.迭代器 KeySet 删除安全
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer key = iterator2.next();
            System.out.print(key);
            System.out.print(map.get(key));
        }
        System.out.println("------------");

        //3.ForEach EntrySet
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
        System.out.println("------------");

        //4.ForEach KeySet
        for (Integer key : map.keySet()) {
            System.out.print(key);
            System.out.print(map.get(key));
        }
        System.out.println("------------");

        //5.Lambda 过滤删除安全
        map.forEach((key, value) -> {
            System.out.print(key);
            System.out.print(value);
        });
        System.out.println("------------");

        //6.Streams API 单线程
        map.entrySet().stream().forEach((entry) -> {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        });
        System.out.println("------------");

        //7.Streams API 多线程 性能最高，其他六种性能完全一样没差别
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        });
    }
}
