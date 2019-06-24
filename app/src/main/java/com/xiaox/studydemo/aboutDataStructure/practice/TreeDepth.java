package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度
 *
 * @date 2019/6/24
 * @author:xiaox
 */
public class TreeDepth {

    static ArrayList<Integer> mArrayList = new ArrayList<>();

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node6.right = node7;

        treeDepth1(node1);

    }


    /**
     * 递归实现
     */
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }


    /**
     * 循环实现
     */
    public static int treeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        int count = 0;//记录遍历到这一层的第几个节点
        int nextCount = 1;//记录当层节点的个数
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            count++;
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            //遍历完一层就重置，并且depth++
            if (count == nextCount) {
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
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














