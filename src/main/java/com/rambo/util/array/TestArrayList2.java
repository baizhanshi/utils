package com.rambo.util.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 将Arrays.asList(strArray)的返回值由java.util.Arrays.ArrayList转为java.util.ArrayList。
 * 需要在将数组转换为List后，对List进行增删改查操作，在List的数据量不大的情况下，可以使用。
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/22 10:00
 */
public class TestArrayList2 {
    public static void main(String[] args) {
        String[] strArray = new String[2];
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray));
        list.add("1");
        System.out.println(list);
    }
}
