package com.rambo.suanfa;

/**
 * 大数字的乘法 比如：178*12
 *
 * @author ：baizhansi
 * @date ：Created in 2021/1/10 10:17
 */
public class BigShuzi {
    public static void main(String[] args) {
        int[] ints = new int[6];
        ints[ints.length - 1] = 8;
        ints[ints.length - 2] = 7;
        ints[ints.length - 3] = 1;

        int num = 12;
        //计算每一位
        for (int i = 0; i < ints.length; i++) {
            ints[i] *= num;
        }
        //进位和留位
        for (int i = ints.length - 1; i > 0; i--) {
            ints[i - 1] += ints[i] / 10;
            ints[i] = ints[i] % 10;
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
