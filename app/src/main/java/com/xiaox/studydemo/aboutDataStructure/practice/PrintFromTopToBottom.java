package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * 层次遍历
 */
public class PrintFromTopToBottom {

    public static void main(String[] args) {

    }

    /**
     * 借助一个list将二叉树的每个同层节点装起来，再遍历
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            //取出list中的第一个treeNode
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                //有左节点就存起来
                queue.add(temp.left);
            }
            if (temp.right != null) {
                //有右节点继续存起来，这样就可以保证顺序是同层的节点了
                queue.add(temp.right);
            }
            //保存当前节点的数据
            list.add(temp.val);
        }
        return list;
    }


    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
