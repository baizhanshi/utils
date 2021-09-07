package com.rambo.suanfa;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/9/7 19:10
 */
public class 字符串匹配算法 {
    public static void main(String[] args) {
        int index = strStr("hello", "ll");
        System.out.println(index);
    }

    /**
     * @param haystack 主串
     * @param needle   模式串
     * @return
     */
    private static int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int needLen = needle.length();
        if (needLen > hayLen) {
            return -1;
        }
        if (needLen == 0) {
            return 0;
        }
        //主串
        for (int i = 0; i < hayLen - needLen + 1; ++i) {
            int j;
            //模式串
            for (j = 0; j < needLen; j++) {
                //不符合的情况，直接跳出，主串指针后移一位
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            //匹配成功
            if (j == needLen) {
                return i;
            }
        }
        return -1;
    }
}
