package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * @date 2019/6/21
 * @author:xiaox 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {

    private static ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        //10,5,12,4,7
        TreeNode node = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;

        FindPath(node, 22);
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return path;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.right == null && root.left == null) {
            //重新new一个ArrayList是因为list是引用传递，直接操作会影响到结果
            path.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        //不符合条件就将添加进来的value给剔除出去，回溯到上一层
        list.remove(list.size() - 1);
        return path;
    }

    /**
     * 自己的思路，还是有点问题。。。
     */
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        if (root.val < target && root.left != null) {
            //继续向下找
            list.add(root.val);
            FindPath(root.left, target - root.val);
        } else if (root.val == target) {
            list.add(root.val);
            path.add(new ArrayList<Integer>(list));
            return path;
        }else{
            list.remove(list.size()-1);
        }
        if (root.val < target && root.right != null) {
            //继续向下找
            list.add(root.val);
            FindPath(root.right, target - root.val);
        } else if (root.val == target) {
            list.add(root.val);
            path.add(new ArrayList<Integer>(list));
            return path;
        } else {
            list.remove(list.size()-1);
        }
        return path;
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













