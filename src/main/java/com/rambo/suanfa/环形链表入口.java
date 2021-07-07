package com.rambo.suanfa;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/7/7 16:27
 */
import java.util.HashMap;
import java.util.Map;

public class 环形链表入口 {
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
        node6.next = node2;
        System.out.println(detectCycle(node1));
        System.out.println("------------------");
    }

    private static int detectCycle(Node node) {
        int pos = -1;
        Map<Node, Integer> map = new HashMap<>();
        while (node != null) {
            if (map.containsKey(node)) {
                return node.index;
            } else {
                map.put(node, ++pos);
                node = node.next;
            }
        }
        return 0;
    }
}
