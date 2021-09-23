package com.rambo.suanfa.study;

/**
 * 第n层有n个硬币
 * 比如总共六个硬币 返回三（一层1 二层2 三层3 1+2+3=6）
 * 五个硬币只能返回2 第三层没有排满
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/23 20:14
 */
public class 梯形硬币排列 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(6));
    }

    /**
     * 迭代
     *
     * @param n 总硬币数
     * @return 完整的硬币层数位置
     */
    private static int arrangeCoins(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - i;
            //如果总硬币数小于当前层数则返回当前层数即可
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }
}
