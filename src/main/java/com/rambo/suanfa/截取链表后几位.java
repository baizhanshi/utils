package com.rambo.suanfa;

/**
 * 1->2->3->4->5  k=2
 * 得到4->5
 * 时间复杂度O（N）
 *
 * @date ：Created in 2021-8-5 9:39
 */
public class 截取链表后几位 {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println("截取前：" + node1.toString());
        Node newNode = nodeCutOut(node1, 2);
        System.out.println("截取后：" + newNode.toString());
    }

    /**
     * 根据参数截取链表的后几位
     *
     * @param node
     * @param key
     * @return
     */
    private static Node nodeCutOut(Node node, int key) {
        //前指针
        Node head = node;
        //后指针
        Node last = node;
        for (int i = 0; i < key; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            last = last.next;
        }
        return last;
    }
}

