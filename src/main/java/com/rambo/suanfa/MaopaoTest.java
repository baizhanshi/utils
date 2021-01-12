package com.rambo.suanfa;

/**
 * 冒泡排序 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/12/21 16:07
 */
public class MaopaoTest {
    public static void main(String[] args) {
        int[] numbers = { 1, 4, 5, 8, 3, 10 };
        bubbleSort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {//开头的一个
            for (int j = 0; j < size - 1 - i; j++) {//结束的一个
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}
