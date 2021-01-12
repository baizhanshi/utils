package com.rambo.suanfa;

/**
 * 二分查找算法
 * 
 * @author ：baizhansi
 * @date ：Created in 2021/1/10 20:07
 */
public class ErFenSuanfa {
    public static void main(String[] args) {
        int[] ints = { 4, 2, 8, 9, 5, 4, 3 };
        int num = 9;//要查找的数字
        int start = 0;//开始位置
        int end = ints.length - 1;//结束位置
        int middle = 0;//中间位置

        while (start <= end) {
            middle = (start + end) / 2;//中间位置
            if (num == ints[middle]) {
                System.out.println("找到了索引位置：" + middle);
                return;
            } else if (num < ints[middle]) {//左边
                end = middle - 1;
            } else {//右边
                start = middle + 1;
            }
        }
        System.out.println("没有找到");
    }
}
