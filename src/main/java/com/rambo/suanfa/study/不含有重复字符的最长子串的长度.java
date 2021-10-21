package com.rambo.suanfa.study;


import java.util.HashSet;
import java.util.Set;

/**
 * @author ：BAIZHANSHI998
 * @date ：Created in 2021-10-20 17:08
 */
public class 不含有重复字符的最长子串的长度 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        //设定最大长度为1
        int maxLen = 1;
        //左、右指针
        int left = 0, right = 0;

        Set<Character> window = new HashSet<>();
        while (right < n) {
            char rightChar = s.charAt(right);
            while (window.contains(rightChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            //最大长度对比
            maxLen = Math.max(maxLen, right - left + 1);
            window.add(rightChar);
            right++;
        }
        return maxLen;
    }
}




