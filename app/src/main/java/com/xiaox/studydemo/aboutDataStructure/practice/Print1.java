package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * @date 2019/7/1
 * @author:xiaox 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 */
public class Print1 {


    /**
     * 分成奇偶层，每层用不同的list去装
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        ArrayList<TreeNode> queue1 = new ArrayList<>();
        ArrayList<TreeNode> queue2 = new ArrayList<>();
        int layer = 1;
        queue1.add(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (layer % 2 == 0) {
                //偶数层
                ArrayList<Integer> integers = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.remove(0);
                    if (node.left != null) {
                        queue1.add(node.left);
                    }
                    if (node.right != null) {
                        queue1.add(node.right);
                    }
                    integers.add(node.val);
                }
                lists.add(integers);
            } else {
                //奇数层
                ArrayList<Integer> integers = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.remove(0);
                    if (node.left != null) {
                        queue2.add(node.left);
                    }
                    if (node.right != null) {
                        queue2.add(node.right);
                    }
                    integers.add(node.val);
                }
                lists.add(integers);
            }
            layer++;
        }
        return lists;
    }

    /**
     * 递归实现
     */
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        getResult(pRoot, lists, 1);
        return lists;
    }

    /**
     * @param depth 当前tree的深度（第几层）
     */
    private void getResult(TreeNode pRoot, ArrayList<ArrayList<Integer>> lists, int depth) {
        if(pRoot == null) {
            return;//递归的出口
        }
        // depth >lists.size(),说明之前没有遍历到这一层，先add一个当前层的list进去
        if (depth > lists.size()) {
            lists.add(new ArrayList<Integer>());
        }
        // 拿到当前这一层的list保存节点的值
        lists.get(depth - 1).add(pRoot.val);
        // 向下递归
        getResult(pRoot.left, lists, depth + 1);
        getResult(pRoot.right, lists, depth + 1);
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
