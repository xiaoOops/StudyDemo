package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @version V1.0
 * 删除一个单项链表中的一项
 */
public class DeleteLinkedList {

    public static void main(String[] arg) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node2;
        node2.next = node3;
        ListNode node = delete2(node1, node3);
    }

    /**
     * 删除单向链表中的指定节点
     */
    public static ListNode delete(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        //创建一个node保存头节点
        ListNode node = new ListNode(0);
        node.next = head;
        //创建两个指针，从第二个节点开始遍历
        ListNode temp = node.next;
        ListNode pre = node.next;
        while (temp != null && pre != null) {
            if (temp.next != null && temp.next.val == val) {
                //找到要删除的那个节点，调整指针位置
                pre.next = temp.next.next;
                break;
            } else {
                pre = pre.next;
                temp = temp.next;
            }
        }
        return node.next;
    }

    /**
     * 时间复杂度为O(n)
     * 思路：从头节点开始遍历，找到要删除的节点的前一个节点，调整指针
     */
    public static ListNode delete1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        //保存头节点
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.val == val) {
                //找到要删除的那个节点，调整指针位置
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 要求时间复杂度为O(1)
     *
     * 思路：不是一定要找到要删除的节点的前一个节点，例如我们需要删除节点i，可以先把节点i的下一个节点j复制到i上来，
     * 再把i的指针指向j的下一个节点，就能达到删除节点i的效果。
     *
     * 时间复杂度分析：
     * 对于有n个节点的链表，当待删除节点是头节点或是中间节点时的时间复杂度是O(1)
     * 当待删除节点是尾节点时，时间复杂度是O(n)，因此平均的时间复杂度是[n*1+n]/n,结果还是O(1)
     *
     * 代码还是有问题的，因为已经默认toBeDelete是链表中的某一个节点，如果不确定这一点的话，还是需要遍历链表..
     */
    public static ListNode delete2(ListNode head, ListNode toBeDelete) {
        if (head == null || toBeDelete == null) {
            return head;
        }
        if (toBeDelete.next != null) {
            //有多个节点且带删除的是中间节点
            toBeDelete.val = toBeDelete.next.val;
            toBeDelete.next = toBeDelete.next.next;
            return head;
        } else if (head.val == toBeDelete.val) {
            //待删除是否是头节点
            return head.next;
        } else {
            //待删除的是尾节点
            ListNode temp = head;
            while (temp.next != null) {
                if (temp.next.val != toBeDelete.val) {
                    temp = temp.next;
                } else {
                    temp.next = null;
                }
            }
            return head;
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





















