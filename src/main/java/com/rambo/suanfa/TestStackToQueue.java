package com.rambo.suanfa;

import com.rambo.tools.StringUtil;

import java.util.Objects;
import java.util.Stack;

/**
 * 栈转队列
 * @author ：baizhanshi
 * @date ：Created in 2021/5/23 9:27
 */
public class TestStackToQueue {
    private Stack stackA = new Stack();
    private Stack stackB = new Stack();

    /**
     * 入队
     * @param param
     */
    private void enQueue(int param){
        stackA.push(param);
    }

    /**
     * 出队
     */
    private void deQueue(){
        if (Objects.isNull(stackA)){
            System.out.println("请添加栈数据！");
        }
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
        while (stackB.size()>0){
            System.out.println(stackB.pop());
        }

    }

    public static void main(String[] args) {
        TestStackToQueue testStackToQueue = new TestStackToQueue();
        for (int i = 0; i <=3; i++) {
            testStackToQueue.enQueue(i);
        }
        testStackToQueue.deQueue();
    }
}
