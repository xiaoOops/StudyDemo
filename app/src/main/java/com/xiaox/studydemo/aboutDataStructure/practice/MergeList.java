package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @date 2019/6/19
 * @author:xiaox
 */
public class MergeList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(6);
        ListNode listNode8 = new ListNode(8);
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        ListNode merge = merge1(listNode1, listNode5);

    }

    /**
     * 递归思想
     */
    public  static ListNode merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            //list1.val 比 list2.val 小，小的保存起来，继续用list1.next去与list2比较
            list1.next = merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = merge1(list1, list2.next);
            return list2;
        }
    }


    /**
     * 将 list1 的头节点与 list2 的头结点比，小的存起来，指针向后移一位，继续比较...
     */
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    mergeHead = current = list1;
                } else {
                    //将小的数字存起来
                    current.next = list1;
                    //新的listnode的指针也需要向后移动
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return mergeHead;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}





















