package com.rambo.suanfa;

/**
 * 斐波那契数列 后面一个数等于前边两个数的和
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/21 9:54
 */
public class TestFibo {

    // 使用递归方法
    private static int getFibo(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return getFibo(i - 1) + getFibo(i - 2);
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.print(getFibo(i) + " ");
            if (i % 5 == 0) {//每显示五个数换一行
                System.out.println();
            }
        }
    }

}
