package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 二叉树的镜像定义：
 * <p>
 * <p>
 * 源二叉树
 * *     	    8
 * *     	   /  \
 * *     	  6   10
 * *     	 / \  / \
 * *     	5  7 9 11
 * *
 * *     	镜像二叉树
 * *     	    8
 * *     	   /  \
 * *     	  10   6
 * *     	 / \  / \
 * *     	11 9 7  5
 * ---------------------
 *
 * @date 2019/6/30
 * @author:xiaox
 */
public class IsSymmetrical {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(5);

        TreeNode otherRoot = new TreeNode(8);
        TreeNode otherNode1 = new TreeNode(10);
        TreeNode otherNode2 = new TreeNode(6);
        TreeNode otherNode3 = new TreeNode(11);
        TreeNode otherNode4 = new TreeNode(9);
        TreeNode otherNode5 = new TreeNode(7);
        TreeNode otherNode6 = new TreeNode(12);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        otherRoot.left = otherNode1;
        otherRoot.right = otherNode2;
        otherNode1.left = otherNode3;
        otherNode1.right = otherNode4;
        otherNode2.left = otherNode5;
        otherNode2.right = otherNode6;


        boolean ifSame = checkIfSame(root, otherRoot);
        System.out.println(ifSame);
        //isSymmetrical(root);

    }

    /**
     * 递归实现：
     * 首先根节点以及其左右子树
     * 左子树的左子树和右子树的右子树相同
     * 左子树的右子树和右子树的左子树相同即可
     */
    public static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isTheMirror(pRoot.left, pRoot.right);
    }

    private static boolean isTheMirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else {
            if (left.val != right.val) {
                return false;
            } else {
                //这里是用左子树的左子树和右子树的右子树比较 && 左子树的右子树和右子树的左子树比较
                return isTheMirror(left.left, right.right) && isTheMirror(left.right, right.left);
            }
        }
    }


    /**
     * 非递归实现
     * 使用一个stack来装左右子树，并分别比较
     */
    public static boolean isSymmetrical1(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()) {
            //成对取出
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null) {
                return node1 == node2;
            }
            if (node1.val != node2.val) {
                return false;
            }
            //成对入栈
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }


    /**
     * 递归实现2棵树是否相等
     */
    private static boolean checkIfSame(TreeNode pRoot, TreeNode mirror) {
        if (pRoot == null || mirror == null) {
            return pRoot == mirror;
        } else if (pRoot != null && mirror != null) {
            if (pRoot.val != mirror.val) {
                return false;
            } else if (checkIfSame(pRoot.left, mirror.left) && checkIfSame(pRoot.right, mirror.right)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 递归实现一棵树的镜像
     */
    private static void mirrorTree(TreeNode pRoot) {

        if (pRoot != null) {
            TreeNode temp = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = temp;
        }
        if (pRoot != null && pRoot.left != null) {
            mirrorTree(pRoot.left);
        }
        if (pRoot != null && pRoot.right != null) {
            mirrorTree(pRoot.right);
        }


    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
