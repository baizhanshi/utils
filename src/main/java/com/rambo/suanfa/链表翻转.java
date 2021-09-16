package com.rambo.suanfa;

import com.rambo.suanfa.Node;

/**
 * 链表反转
 * 1->2->3->4->5->6->7
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/7 19:13
 */
public class 链表翻转 {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node7 = new Node(7, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        System.out.println("反转前：" + node1.toString());
        Node newnode = reverseList(node1);
        System.out.println("反转后：" + newnode.toString());
    }

    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        //把前一个节点指向当前节点的下一个节点
        Node pre = null;
        while (node != null) {
            Node next = node.next;//node2
            node.next = pre;//null
            pre = node;
            node = next;//nodecurr=node2
        }
        return pre;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    //递归法会逐层确定该节点有没有next节点，若为空，则认定递归到最深层元素。同时将该层节点的next指向父节点，在递归栈中以此类推。
    static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

}

