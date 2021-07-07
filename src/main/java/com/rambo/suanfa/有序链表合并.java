package com.rambo.suanfa;

/**
 * 1->3->5
 * 2->4->6
 * 结果
 * 1->2->3->4->5->6
 * @author ：baizhanshi
 * @date ：Created in 2021/7/7 16:23
 */
public class 有序链表合并 {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        node1.next = node3;
        node3.next = node5;
        System.out.println("node1" + node1);
        node2.next = node4;
        node4.next = node6;
        System.out.println("node2" + node2);

        System.out.println(mergeToList(node1, node2));
    }

    /**
     * 合并链表(递归)
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node mergeTwoNodeList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //合并后的链表
        Node head = null;
        if (head1.index > head2.index) {
            //把head较小的结点给头结点
            head = head2;
            //继续递归head2
            head.next = mergeTwoNodeList(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeTwoNodeList(head1.next, head2);
        }
        return head;
    }

    /**
     * 合并链表(迭代)
     *
     * @param head1
     * @param head2
     * @return
     */
    private static Node mergeToList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        Node NewHead = null;//新的链表存放合并好的链表
        Node NewTail = null;//链表尾插需要遍历链表,找到链表末尾才能插入
        // 为了方便,用NewTail把链表末尾记录下来
        while (cur1 != null && cur2 != null) {
            if (cur1.index < cur2.index) {
                //那就将cur1插入到新链表末尾
                //需要考虑两种情况,新链表末尾NewTail是否为空
                if (NewTail == null) {
                    NewHead = cur1;
                    NewTail = cur1;
                } else {
                    NewTail.next = cur1;
                    NewTail = NewTail.next;//更新NewTail的位置
                }
                cur1 = cur1.next;
            } else {
                //那就将cur2插入到新链表末尾
                //需要考虑两种情况,新链表末尾NewTail是否为空
                if (NewTail == null) {
                    NewHead = cur2;
                    NewTail = cur2;
                } else {
                    NewTail.next = cur2;
                    NewTail = NewTail.next;//更新NewTail的位置
                }
                cur2 = cur2.next;
            }
        }
        //当循环结束时,说明cur1和cur2有一个走到了末尾
        //把没走到末尾的剩下的链表都连在新链表末尾NewTail的后面
        if (cur1 == null) {
            NewTail.next = cur2;
        } else {
            NewTail.next = cur1;
        }
        return NewHead;
    }
}
