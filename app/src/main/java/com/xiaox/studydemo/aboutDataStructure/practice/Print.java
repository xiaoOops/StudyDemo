package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @date 2019/6/30
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 */
public class Print {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);


        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;


        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.left = b;
        b.right = c;

        Print(a);

    }

    /**
     * 思路：
     * 使用2个stack，分别存放奇数层和偶数层节点，当遍历到奇数层是，先装左节点，再装右节点，
     * 遍历到偶数层时，反过来装，充分利用stack先进后出的特效
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        //记录层数
        int layer = 1;
        //存放奇数层子树
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        //存放偶数层子树
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (layer % 2 == 0) {
                //偶数层
                ArrayList<Integer> integers = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    integers.add(node.val);
                }
                list.add(integers);
            } else {
                //奇数层
                ArrayList<Integer> integers = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    integers.add(node.val);
                }
                list.add(integers);
            }
            layer++;
        }
        return list;
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
