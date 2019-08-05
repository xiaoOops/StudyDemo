package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @date 2019/6/27
 */
public class DeleteDuplication {

    public static void main(String[] arg) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = deleteDuplication(node1);
    }

    /**
     * 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
     * <p>
     * 2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索。
     */
    public static ListNode deleteDuplication(ListNode pHead) {

        //添加一个-1节点，方便保存头节点
        ListNode head = new ListNode(0);

        head.next = pHead;

        ListNode pre = head;
        ListNode last = head.next;

        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                //如果有多个连续的重复节点，找到最后一个重复的节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                //将重复的节点的下一个赋值给pre和last指针，即抛弃了重复节点
                pre.next = last.next;
                break;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }

    /**
     * 递归实现
     */
    public static ListNode deleteDuplication1(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //说明此时是有重复的节点
        if (pHead.val == pHead.next.val) {
            ListNode temp = pHead.next;
            while (temp.next != null && temp.val == temp.next.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                temp = temp.next;
            }
            return deleteDuplication1(temp);
        } else {
            // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }

    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}





















