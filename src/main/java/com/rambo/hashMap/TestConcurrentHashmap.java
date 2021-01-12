package com.rambo.hashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/12/23 17:29
 */
public class TestConcurrentHashmap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        System.out.println(map.mappingCount());//推荐使用，返回类型是long
        System.out.println(map.size());//返回是int，最大值是integer.MAX_VALUE,限制了concurrenthashmap的存储数量
    }
}
