package com.rambo.suanfa;

/**
 * 1*2*3*4*5 阶乘
 * 数字很小时这个是可以支持的，但如果阶乘数字太大的就会出问题的比如n=60
 * 以为超出了int的范围
 * 
 * @author ：baizhansi
 * @date ：Created in 2021/1/10 10:11
 */
public class Jiechengsuanfa {
    public static void main(String[] args) {
        int num = 1;
        int n = 5;
        //第一种写法：
        for (int i = 1; i <= n; i++) {
            num = num * i;
        }
        System.out.println(num);

        //第二种写法（数组的写法）：
        int[] ints = new int[n];
        ints[ints.length - 1] = 1;
        for (int i = 1; i <= n; i++) {
            ints = demo(ints, i);
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    //静态方法
    static int[] demo(int[] ints, int num) {
        //计算每一位
        for (int i = 0; i < ints.length; i++) {
            ints[i] *= num;
        }
        //进位和留位
        for (int i = ints.length - 1; i > 0; i--) {
            ints[i - 1] += ints[i] / 10;
            ints[i] = ints[i] % 10;
        }
        return ints;
    }
}
