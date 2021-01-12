package com.rambo.suanfa;

import java.util.Arrays;

/**
 * @author ：baizhansi
 * @date ：Created in 2021/1/10 20:42
 */
public class BigShuzi2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoBigNum("178", "178", 6, 6)));

    }

    /**
     * 计算两个字符串表示的大数值之间的相乘结果
     * 
     * @param num1 字符串形式的第一个大数值
     * @param num2 字符串形式的第二个大数值
     * @param len1 存放第一个大数值的数组长度
     * @param len2 存放第二个大数值的数组长度
     * @return
     */
    public static int[] twoBigNum(String num1, String num2, int len1, int len2) {
        //把字符串形式的数值转换为字符数组，便于转换成数字形式的数组
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        //声明的数组用于存放大数值中的每一位
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        int[] result = new int[len1];
        //中间变量数组
        int[] temp;
        //表示每一次错位相加需要错开数组中的几位
        int pos = 0;
        //把数字字符串转成数组
        for (int i = chars1.length - 1; i >= 0; i--) {
            nums1[len1 - 1 - (chars1.length - 1 - i)] = Integer.parseInt(String.valueOf(chars1[i]));
        }
        for (int i = chars2.length - 1; i >= 0; i--) {
            nums2[len2 - 1 - (chars2.length - 1 - i)] = Integer.parseInt(String.valueOf(chars2[i]));
        }
        //两数组相乘
        for (int i = chars2.length - 1; i >= 0; i--) {
            //第二个数字数组中的每一位与第一个数字数组相乘的结果
            temp = new int[len1];
            for (int j = chars1.length - 1; j >= 0; j--) {

                temp[len1 - 1 - (chars1.length - 1 - j)] = nums1[len1 - 1 - (chars1.length - 1 - j)]
                        * nums2[len2 - 1 - (chars2.length - 1 - i)];
            }
            //错位相加
            for (int k = 0; k < chars1.length; k++) {
                result[len1 - 1 - k - pos] += temp[len1 - 1 - k];
            }
            pos++;

        }
        //通过进位和留位把数组相乘的结果转化为数字数组
        for (int m = len1 - 1; m > 0; m--) {
            result[m - 1] += result[m] / 10;
            result[m] %= 10;
        }
        return result;
    }
}
