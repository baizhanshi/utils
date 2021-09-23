package com.rambo.suanfa.study;


import java.util.HashSet;
import java.util.Set;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/7/7 16:25
 */
public class 判断环形链表 {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(4, null);
        Node node6 = new Node(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node1;
        System.out.println(isCycle(node1));
        System.out.println("------------------");
        System.out.println(isCycleMap(node1));
    }

    /**
     * HashSet 暂存法
     *
     * @param head
     * @return
     */
    private static boolean isCycleMap(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    /**
     * (快慢指针)双指针 跑步
     * <p>
     * 时间复杂度O（1）
     *
     * @param node
     * @return
     */
    private static boolean isCycle(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

