package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/6/21
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 */
public class Clone {

    /**
     * todo 错的，看看书？
     */
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode newPHead = new RandomListNode(0);
        if (pHead == null) {
            return newPHead;
        }
        newPHead.label = pHead.label;
        newPHead.next = pHead.next;
        newPHead.random = pHead.random;
        Clone(pHead.next);
        return newPHead;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}























