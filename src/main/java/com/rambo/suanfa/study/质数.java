package com.rambo.suanfa.study;

/**
 * 质数获取逻辑
 * 
 * @author ：baizhanshi
 * @date ：Created in 2021/3/19 10:15
 */
public class 质数 {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("质数是：" + i);
            }

        }
    }
}
