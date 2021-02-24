package com.rambo.suanfa;

/**
 * @author ：baizhansi
 * @date ：Created in 2021/1/10 20:42
 */
public class BigShuzi2 {
    public static void main(String[] args) {
        System.out.println(twoBigNum("178678954321", "174789954321"));
    }

    /**
     * 计算两个字符串表示的大数值之间的相乘结果
     * 
     * @param num1 字符串形式的第一个大数值
     * @param num2 字符串形式的第二个大数值
     * @return
     */
    public static String twoBigNum(String num1, String num2) {
        //把字符串转成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();
        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];
        //把char转换成int数组。
        for (int i = 0; i < chars1.length; i++) {
            n1[i] = chars1[i] - '0';
        }
        for (int j = 0; j < chars2.length; j++) {
            n2[j] = chars2[j] - '0';
        }
        //逐个相乘
        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                result[i + j] += n1[i] * n2[j];
            }
        }
        //从后往前满十进位
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        //转成string并返回
        String resultStr = "";
        for (int i = 0; i < result.length - 1; i++) {
            resultStr += "" + result[i];
        }
        return resultStr;
    }
}
