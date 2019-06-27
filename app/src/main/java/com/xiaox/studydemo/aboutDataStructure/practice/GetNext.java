package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @Description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * <p>
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * @date 2019/6/27
 */
public class GetNext {


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode head = pNode.next;



        return pNode;
    }


    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}

















