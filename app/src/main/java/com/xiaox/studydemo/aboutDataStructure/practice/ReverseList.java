package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class ReverseList {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = reverseList1(node1);

    }

    private static ListNode reverseList(ListNode head) {
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        if (head == null)
            return null;
        //当前节点是head，pre为当前节点的前一节点，nextNode为当前节点的下一节点
        //需要pre和nextNode的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用nextNode节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和nextNode两个节点
        ListNode pre = null;
        ListNode nextNode = null;
        while (head != null) {
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            nextNode = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = nextNode;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }

    private static ListNode node;

    /**
     * 递归实现
     */
    private static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        reverseNode(head);
        return node;
    }

    private static void reverseNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode next = head.next;
        head.next = node;
        node = head;
        head = next;
        reverseNode(head);
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
