package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/7/2
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * <p>
 *
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class IsBalanced {


    public static void main(String[] args) {

        TreeNode treeNode2 = new TreeNode(10);
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

        //TreeNode treeNode = midOrder(treeNode5, 5);
        IsBalanced_Solution(treeNode5);
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        boolean b = getDepth(root) != -1;
        System.out.println(b);
        return b;
    }

    /**
     * 从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次
     */
    private static int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        if (left == -1)
            return -1;
        int right = getDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
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
