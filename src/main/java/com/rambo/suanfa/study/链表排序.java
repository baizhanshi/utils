package com.rambo.suanfa.study;

/**
 * 1 2 6 4 7 5
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/12/31 20:11
 */
public class 链表排序 {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(6, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(7, null);
        Node node6 = new Node(5, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        sortList(node1);
        System.out.println(node1.toString());
    }

    /**
     * 对链表进行排序：从小到大
     *
     * @param head
     * @return
     */
    public static Node sortList(Node head) {
        //记录每次循环的最小值
        int temp;
        Node curNode = head;
        while (curNode != null) {
            /**
             * 内重循环从当前节点的下一个节点循环到尾节点，
             * 找到和外重循环的值比较最小的那个，然后与外重循环进行交换
             */
            Node nextNode = curNode.next;
            while (nextNode != null) {
                //比外重循环的小值放到前面
                if (nextNode.index < curNode.index) {
                    temp = nextNode.index;
                    nextNode.index = curNode.index;
                    curNode.index = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
}