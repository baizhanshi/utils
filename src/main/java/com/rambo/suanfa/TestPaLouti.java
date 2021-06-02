package com.rambo.suanfa;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 使用递归，使用斐波那契数列的原理
 # n=1： 1种爬法，1
 # n=2： 2种爬法，1 1, 2
 # n=3： 3种， 1 1 1, 1 2, 2 1
 # n=4：5种， 1 1 1 1, 1 2 1, 2 1 1, 1 1 2, 2 2
 # 以上找规律， f(n) = f(n-1) + f(n-2)
 * @author ：baizhanshi
 * @date ：Created in 2021/5/23 15:38
 *
 * 动态规划思想
 */
public class TestPaLouti {

    public static void main(String[] args) {
        long start  =System.currentTimeMillis();
        System.out.println(climbStairs(10));
        System.out.println(System.currentTimeMillis()-start);
        long start1  =System.currentTimeMillis();
        System.out.println(getFibo(10));
        System.out.println(System.currentTimeMillis()-start1);
    }

    //时间复杂度O（1）
    public static long climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for(int i=3;i<=n;i++){
            int temp = i1+i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
    //时间复杂度O（n）
    private static long getFibo(int i) {
        if (i == 1 || i == 2) {
            return i;
        } else {
            return getFibo(i - 1) + getFibo(i - 2);
        }
    }
}
