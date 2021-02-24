package com.rambo.lock.alternate;

/**
 * int和enum都是一样的
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/1/15 10:37
 */
public class TestCas {
    enum readyToRun {//换成num也一样
        T1,
        T2
    }

    private static int num = 1;
    static readyToRun  r   = readyToRun.T1;

    public static void main(String[] args) {
        char[] aI = { '1', '2', '3', '4', '5' };
        char[] aC = { 'A', 'B', 'C', 'D', 'E' };
        new Thread(() -> {
            for (char i : aI) {
                while (num != 1) {//自旋
                }
                System.out.print(i);
                //                r = readyToRun.T2;
                num = 2;
            }
        }).start();

        new Thread(() -> {
            for (char c : aC) {
                while (num != 2) {
                }
                System.out.print(c);
                //                r = readyToRun.T1;
                num = 1;
            }
        }).start();

    }
}
