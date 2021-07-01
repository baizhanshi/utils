package com.rambo.suanfa;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/6/29 16:01
 */
public class 计算回文的长度 {
    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("abc1234321ab",12));
    }

    public static int getLongestPalindrome(String A, int n) {
        // write code here
        char[] chars = A.toCharArray();//将字符串转化为字符数组
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        boolean[][] res = new boolean[n][n];//boolean类型数组，标志数组下标i到j对应元素是否是回文串
        //初始状态
        for (int i = 0; i < n; i++) {
            //res[i][i]表示只有一个元素的时候，直接看做回文串
            res[i][i] = true;
        }
        int max = 0;//记录最长无重复字符回文串
        for (int bound = 1; bound < n; bound++) {
            for (int cur = bound - 1; cur >= 0; cur--) {
                if (chars[cur] != chars[bound]) {
                    //当chars[cur]!=chars[bound]表示不是回文串，对应位置赋值为false
                    res[cur][bound] = false;
                } else if (bound - cur < 3 || res[cur + 1][bound - 1]) {
                    //1.执行到这个else if 表示chars[cur]=chars[bound]
                    //2.条件bound-cur<3表示在1的条件下，当前子串只有3个元素，为回文串
                    //3.当res[cur+1][bound-1]为true时，当前子串为回文串，因为D(i,j)是否是回文串依赖于 D(i+1,j-1),
                    res[cur][bound] = true;
                }
                //记录最长子串
                if (bound - cur + 1 > max && res[cur][bound]) {
                    max = Math.max(max, bound - cur + 1);
                }
            }
        }
        return max;
    }

}
