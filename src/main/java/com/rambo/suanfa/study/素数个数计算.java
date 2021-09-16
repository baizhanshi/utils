package com.rambo.suanfa.study;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/9/16 19:09
 */
public class 素数个数计算 {
    public static void main(String[] args) {
        System.out.println(bf(100));
        System.out.println(aishuai(100));
    }

    /**
     * 埃氏筛法
     *
     * @param n
     * @return
     */
    public static int aishuai(int n) {
        boolean[] isPrime = new boolean[n];//false代表素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i * i; j < n; j += i) {//j就是合数的标记位
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    /**
     * 暴力计算
     *
     * @param n
     * @return
     */
    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            //int j = 2; j * j <= i; j++ 这种方式类似于int j = 2; j <根号i; j++
            // 比：int j = 2; j < i; j++性能更好遍历次数更少
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                count += 1;
            }
        }
        return count;
    }
}