package com.rambo.util.array;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList(strArray)方式仅能用在将数组转换为List后，不需要增删其中的值，仅作为数据源读取使用。
 * @author ：baizhansi
 * @date ：Created in 2020/10/22 9:55
 */
public class TestArrayList {
    public static void main(String[] args) {
        String[] strArray = new String[2];
        List list = Arrays.asList(strArray);
        //对转换后的list插入一条数据
        list.add("1");
        System.out.println(list);
    }
}
