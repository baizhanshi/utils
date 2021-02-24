package com.rambo.suanfa;

import org.apache.commons.collections4.bag.HashBag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组经过循环次数最少找出重复元素
 * 
 * @author ：baizhanshi
 * @date ：Created in 2021/1/29 9:47
 */
public class TestLast {
    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 8 };
        int[] b = { 1, 2, 4, 5, 6, 9 };
        //        Arrays.sort(a);
        //        Arrays.sort(b);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (Arrays.binarySearch(b, a[i]) >= 0) {//采用的也是二分查找法
                System.out.print(b[i] + " ");
            }
        }
        System.out.println();
        //第二种写法
        int[] M = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] N = { 5, 2, 6, 7, 8, 9 };
        Set<Integer> setM = new HashSet<Integer>();
        for (int m : M) {
            setM.add(m);//将数组M添加到setM中为了为了避免M中的重复元素
        }

        Set<Integer> setN = new HashSet<Integer>();
        for (int n : N) {
            setN.add(n);//将数组N添加到setN中为了为了避免M中的重复元素
        }
        HashBag bag = new HashBag();//HashBag是一个org.apache.commons.collections.bag包中的类，可以很简单的求出两个集合中的交集
        bag.addAll(setM);
        bag.addAll(setN);
        System.out.println(bag);//A:B，A代表重复个数，B代表元素

        //第三种写法（已排序）自旋写法
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
    }
}
