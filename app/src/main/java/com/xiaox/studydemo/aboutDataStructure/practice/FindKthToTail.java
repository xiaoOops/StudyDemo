package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTail {

    /**
     * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指针走(k-1)步，到达第k个节点。
     * 然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            if (head.next != null) {
                first = first.next;
            }else {
                //如果next是null的话，说明k的值大于链表的长度，直接返回null
                return null;
            }
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}


























