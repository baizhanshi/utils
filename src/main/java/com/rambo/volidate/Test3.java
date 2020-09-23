package com.rambo.volidate;

import java.util.concurrent.TimeUnit;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/6/9 15:49
 */
public class Test3 {
    private static boolean flag = false;
    private static  Integer i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                flag = true;
                System.out.println("flag 被修改成 true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        while (!flag) {
            i++;
//            try {
//                TimeUnit.MICROSECONDS.sleep(10);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("flag标识=" + flag);
        }
        System.out.println("程序结束,i=" + i);
    }
}
