package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/6/21
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 */
public class Clone {


    public static void main(String[] args){
        RandomListNode node1=new RandomListNode(1);
        RandomListNode node2=new RandomListNode(2);
        RandomListNode node3=new RandomListNode(3);

        node1.next =node2;
        node2.next=node3;

        RandomListNode clone = Clone(node1);

    }

    /**
     * todo 错的，看看书？
     */
    public static RandomListNode Clone(RandomListNode pHead) {
        RandomListNode newPHead = new RandomListNode(0);
        newPHead.next = pHead;
        RandomListNode pre = newPHead.next;
        while (pre != null) {
            pre = pre.next;
        }
        return newPHead.next;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}























