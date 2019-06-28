package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * @Description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * <p>
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * @date 2019/6/27
 */
public class GetNext {

    ArrayList<TreeLinkNode> mTreeLinkNodes = new ArrayList<>();


    /**
     * 1.二叉树为空，则返回空；
     * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，下一个节点就是右子树最左边的点；
     * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；
     * 否则继续向上遍历其父节点的父节点，重复之前的判断，即直到当前结点是其父节点的左孩子位置，返回结果。
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            //情况2，如果右子树存在，则从右子树出发，找到右子树的左子节点
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        //情况3，判断该节点是否为父节点的左子树，不是的话继续向上遍历，重复判断
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }


    /**
     * 直接中序遍历一遍。。。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //TreeLinkNode head = pNode.next;
        InOrder(pNode);
        int i = mTreeLinkNodes.indexOf(pNode);
        TreeLinkNode linkNode = mTreeLinkNodes.get(i + 1);
        return linkNode;
    }

    /**
     * 中序遍历二叉树
     */
    public void InOrder(TreeLinkNode node) {
        if (node != null) {
            InOrder(node.left);  //中序遍历左子树
            mTreeLinkNodes.add(node);
            InOrder(node.right);  //中序遍历右子树
        }
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

















