package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.Stack;

/**
 * @date 2019/7/2
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 */
public class Convert {

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode5.left = treeNode3;
        treeNode5.right = treeNode7;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode7.left = treeNode6;
        treeNode7.right = treeNode8;

        Convert(treeNode5);
    }

    static TreeNode temp; //创建一个引用
    static TreeNode head; //多创建一个引用保存头节点

    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode node = inOrder1(pRootOfTree);
        return node;
    }

    /**
     * 利用中序遍历，递归
     */
    private static void inOrder(TreeNode pRootOfTree) {
        if (pRootOfTree != null) {
            inOrder(pRootOfTree.left);
            if (temp == null) {
                //递归到最下层的时候保存头节点
                temp = pRootOfTree;
                head = pRootOfTree;
            } else {
                //将上一层拿到的节点的向后指向当前节点，再把当前节点的向前指向上一层节点，再把当前节点赋值给上一节点，继续递归
                temp.right = pRootOfTree;
                pRootOfTree.left = temp;
                temp = pRootOfTree;
            }
            inOrder(pRootOfTree.right);

        }
    }


    /**
     * 非递归实现
     */
    private static TreeNode inOrder1(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRootOfTree;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;//先遍历左子树
            }
            node = stack.pop();
            if (pre == null) {
                pRootOfTree = node;//保存中序遍历的第一个节点
                pre = node;
            } else {
                //调整指针
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            node = node.right;//再遍历右子树
        }
        return pRootOfTree;

    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;//上一节点
        TreeNode right = null;//下一节点

        public TreeNode(int val) {
            this.val = val;

        }

    }

}











