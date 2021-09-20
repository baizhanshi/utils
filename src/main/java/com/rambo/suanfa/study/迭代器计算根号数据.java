package com.rambo.suanfa.study;
/**
 * 取最接近的正整数，比如根号16=4 根号17 也等于4
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/20 9:20
 */
public class 迭代器计算根号数据 {
    public static void main(String[] args) {
        System.out.println(newton(24));
    }

    /**
     * 迭代器方式-牛顿迭代
     *
     * @param x
     * @return
     */
    private static int newton(int x) {
        return (int) sqrt(x, x);
    }

    private static double sqrt(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrt(res, x);
        }
    }
}
