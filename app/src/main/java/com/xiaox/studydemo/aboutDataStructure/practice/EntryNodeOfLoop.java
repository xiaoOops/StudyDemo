package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.HashSet;

/**
 * @Description:给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 * @date 2019/6/27
 */
public class EntryNodeOfLoop {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        EntryNodeOfLoop1(node);
    }

    /**
     * 使用了额外的空间
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode node = null;
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                node = pHead;
                break;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return node;
    }


    /**
     * https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4
     * <p>
     * 定理：两个指针一个fast、一个slow同时从一个链表的头部出发
     * fast一次走2步，slow一次走一步，如果该链表有环，两个指针必然在环内相遇
     * 此时只需要把其中的一个指针重新指向链表头部，另一个不变（还在环内），
     * 这次两个指针一次走一步，相遇的地方就是入口节点。
     */
    public static ListNode EntryNodeOfLoop1(ListNode pHead) {
        ListNode pFast = pHead;
        ListNode pSlow = pHead;
        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) {
                //此时在环中相遇
                break;
            }
        }
        //排除没有环的情况
        if (pFast == null || pFast.next == null) {
            return null;
        }
        //重置一个指针，此时fast==slow.
        pFast = pHead;
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}











