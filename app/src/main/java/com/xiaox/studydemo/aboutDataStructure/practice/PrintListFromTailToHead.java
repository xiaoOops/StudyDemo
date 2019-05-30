package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/5/29
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class PrintListFromTailToHead {


    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     *
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        list = solution1(listNode);
        return list;
    }

    /**
     * 使用stack装，然后再一一出栈
     */
    private ArrayList<Integer> solution1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 递归
     */
    public ArrayList<Integer> solution2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            solution2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
