package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/6/21
 * 35:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
 */
public class Clone {


    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node5;
        node4.random = node2;

        //RandomListNode clone = clone(node1);

        test(node1);
    }


    private static void test(RandomListNode head){

        RandomListNode node = head;
        node.label=99;
        System.out.println(head.label);//99
    }


    /**
     * https://www.nowcoder.com/profile/2396500/codeBookDetail?submissionId=18667115
     */
    private static RandomListNode clone(RandomListNode pHead) {
        //第一步：复制原始链表的每个元素n到n1，并把n1链接到n后面
        cloneNodes(pHead);
        //第二步：设置复制出来的n1节点的random字段
        setRandomNodes(pHead);
        //第三步：拆分原始链表将偶数位的node拆出来就是复制出来的链表了
        RandomListNode cloneList = getCloneList1(pHead);
        return cloneList;
    }

    /**
     * 拆分链表怎么理解？
     */
    private static RandomListNode getCloneList1(RandomListNode pHead) {
        // node a,a1,b,b1,c,c1,d,d1,e,e1
        RandomListNode node = pHead;
        // cloneHead a1,b,b1,c,c1,d,d1,e,e1
        RandomListNode cloneHead = pHead.next;
        while (node != null) {
            //将原始链表的下个节点作为拆分出来的链表的头节点
            RandomListNode cloneNode = node.next;
            //将复制链表的下一个节点作为原链表的下一个节点，等于是抛弃掉复制出来的那一个节点
            //cloneNode a1,b,b1,c,c1,d,d1,e,e1
            // node a,a1,b,b1,c,c1,d,d1,e,e1  -> node a,b,b1,c,c1,d,d1,e,e1
            node.next = cloneNode.next;
            if (cloneNode.next != null) {
                //将复制链表的下下个节点作为当前节点的下一个节点，等于是抛弃掉原链表中的节点
                //cloneNode a1,b,b1,c,c1,d,d1,e,e1 -> cloneNode a1,b1,c,c1,d,d1,e,e1
                cloneNode.next = cloneNode.next.next;
            }
            //移动原链表指针
            node = node.next;
        }
        return cloneHead;
    }

    private static RandomListNode getCloneList(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode cloneHead = null;
        RandomListNode clone = null;
        //node=1,1,2,2,3,3,4,4,5,5
        if (node != null) {
            clone = node.next;
            cloneHead = node.next;
            node.next = clone.next;
            node = node.next;
        }
        //node  =2,2,3,3,4,4,5,5
        //clone =1,2,2,3,3,4,4,5,5
        while (node != null) {
            clone.next = node.next;
            clone = clone.next;
            node.next = clone.next;
            node = node.next;
        }
        return cloneHead;
    }

    private static void setRandomNodes(RandomListNode pHead) {
        while (pHead != null) {
            if (pHead.next != null) {
                pHead.next.random = pHead.random;
                pHead = pHead.next.next;
            }
        }
    }

    private static void cloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode clone = new RandomListNode();
            clone.label = node.label;
            clone.next = node.next;
            clone.random = null;

            node.next = clone;
            node = clone.next;
        }
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        RandomListNode() {
        }
    }

}























