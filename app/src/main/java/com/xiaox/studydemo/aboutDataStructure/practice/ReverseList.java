package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class ReverseList {


    /*
     * 使用stack
     */
    public ListNode ReverseList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp.next != null) {
            temp = head.next;
            stack.push(temp.next);
        }
        return stack.peek();

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
