package com.rambo.util.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 需要在将数组转换为List后，对List进行增删改查操作，在List的数据量巨大的情况下，优先使用，可以提高操作速度。
 * @author ：baizhansi
 * @date ：Created in 2020/10/22 10:00
 */
public class TestArrayList3 {
    public static void main(String[] args) {
        String[] strArray = new String[2];
        ArrayList<String> arrayList = new ArrayList<String>(strArray.length);
        Collections.addAll(arrayList, strArray);
        arrayList.add("1");
        System.out.println(arrayList);
    }
}
