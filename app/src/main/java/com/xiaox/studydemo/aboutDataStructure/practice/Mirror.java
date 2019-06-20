package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像
 * @date 2019/6/20
 * @author:xiaox
 *
 * 二叉树的镜像定义：
 *
 *       源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root);
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }

    private void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}















