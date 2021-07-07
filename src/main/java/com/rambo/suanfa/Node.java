package com.rambo.suanfa;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/7/7 16:23
 */
public class Node {
    int  index;
    Node next;

    public Node(int index, Node next) {
        this.index = index;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + "index=" + index + ", next=" + next + '}';
    }
}
