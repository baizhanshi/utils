package com.rambo.suanfa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列转栈
 * @author ：baizhanshi
 * @date ：Created in 2021/5/23 9:37
 */
public class TestQueueToStack {

    private Queue<Integer> queueA = new LinkedList<>();

    private Queue<Integer> queueB = new LinkedList<>();

    //入队
    public void push(int num) {
        queueA.add(num);
    }
    //出队
    private int pop(){
        while (queueA.size()>1){
            queueB.add(queueA.poll());
        }
        int res = queueA.poll();
        swap();
        return res;
    }

    //交换
    private void swap(){
        Queue temp = queueB;
        queueB = queueA;
        queueA = temp;
    }

    public static void main(String[] args) {
        TestQueueToStack testQueueToStack =new TestQueueToStack();
        for (int i = 1; i <=3 ; i++) {
            testQueueToStack.push(i);
        }
        System.out.println(testQueueToStack.pop());
        System.out.println(testQueueToStack.pop());
        System.out.println(testQueueToStack.pop());
    }
}
