package com.rambo.suanfa.study;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定字符串 输出出现次数最多最先出现的字符
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/11/14 10:49
 */
public class 出现次数最多最先出现的字符串 {
    public static void main(String[] args) {
        System.out.println(getMaxCount("hello word every body"));
    }


    private static char getMaxCount(String str) {
        //设定出现的最大 次数为1
        int maxCount = 1;
        char[] ca = str.toCharArray();
        //设定返回的字符串
        char result = new Character(str.charAt(0));
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : ca) {
            Integer count = map.get(c);
            if (count != null) {
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }
        //循环map 如果当前字符串出现的次数大于最大值，进行替换
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                result = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return result;
    }
}
