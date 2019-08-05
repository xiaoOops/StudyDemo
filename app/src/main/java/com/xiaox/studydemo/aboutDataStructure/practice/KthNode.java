package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * @date 2019/7/1
 * @author:xiaox 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {

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

        KthNode(treeNode5, 3);
        //TreeNode treeNode = midOrder(treeNode5, 5);

    }


    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        midOrder(pRoot, list, k);
        if (k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }


    private static void midOrder(TreeNode pRoot, ArrayList<TreeNode> list, int k) {
        if (pRoot != null) {
            midOrder(pRoot.left, list, k);
            //找到第k个就返回
            if (list.size() == k) {
                return;
            }
            list.add(pRoot);
            //找到第k个就返回
            if (list.size() == k) {
                return;
            }
            midOrder(pRoot.right, list, k);
        }
    }

    static int index = 0;//计数器

    /**
     * 中序遍历寻找第k个
     */
    private static TreeNode midOrder1(TreeNode pRoot, ArrayList<TreeNode> list, int k) {
        if (pRoot != null) {
            TreeNode node = midOrder1(pRoot.left, list, k);
            //当 node != null，说明在下一层的递归时已经找到了符合条件的值了，在这一层直接return这个值结束这一层就好了
            if (node != null) {
                return node;
            }
            index++;
            if (k == index) {
                return pRoot;
            }
            node = midOrder1(pRoot.right, list, k);
            if (node != null) {
                return node;
            }
        }
        return null;

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
















