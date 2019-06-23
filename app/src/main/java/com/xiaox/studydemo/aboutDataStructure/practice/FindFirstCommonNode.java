package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * 输入两个链表，找出它们的第一个公共结点
 *
 * @author:xiaox
 */
public class FindFirstCommonNode {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode node7 = new ListNode(7);
        node7.next = node4;

        findFirstCommonNode1(node1, node7);
    }


    /**
     * 把链表1的尾连到链表2的头，把链表2的尾连到链表1的头，同时遍历，最终会在公共结点相遇
     * {1,2,3,4,5}
     * {7,4,5}
     */
    public static ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = pHead2;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = pHead1;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }


    /**
     * 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
     * （因为2个链表用公共的尾部）
     * {1,2,3,4,5}
     * {7,4,5}
     */
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode commonNode = null;
        int p1 = countLength(pHead1);
        int p2 = countLength(pHead2);
        if (p1 > p2) {
            for (int i = 0; i < p1 - p2; i++) {
                pHead1 = pHead1.next;
            }
        } else {
            for (int i = 0; i < p2 - p1; i++) {
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) {
                commonNode = pHead1;
                break;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return commonNode;
    }

    private static int countLength(ListNode pHead1) {
        ListNode temp = pHead1;
        int length = 1;
        while (pHead1.next != null) {
            length++;
            pHead1 = pHead1.next;
        }
        return length;

    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}
