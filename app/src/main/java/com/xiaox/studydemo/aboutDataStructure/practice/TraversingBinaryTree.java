package com.xiaox.studydemo.aboutDataStructure.practice;

import com.xiaox.studydemo.aboutDataStructure.practice.structure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @date 2019/7/11
 * 遍历二叉树
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5 6   7
 */
public class TraversingBinaryTree {

    static ArrayList<Integer> list = new ArrayList<>();

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

        postOrder2(root);
        System.out.println(list);

    }


    /**
     * 前序遍历:根左右
     */
    private static void preOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
    }


    /**
     * 前序遍历：非递归实现，利用栈模拟递归
     */
    private static void preOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            list.add(node.val);
        }
    }

    /**
     * 中序遍历:左根右
     */
    private static void inOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder1(root.left);
        list.add(root.val);
        inOrder1(root.right);
    }

    /**
     * 中序遍历
     * 要先遍历左子树，然后根节点，最后遍历右子树。所以需要先把跟节点入栈然后在一直把左子树入栈
     * 直到左子树为空，此时停止入栈。栈顶节点就是我们需要访问的节点，取栈顶节点node并访问。然后该节点可能有右子树，所以
     * 访问完节点node后还要判断node的右子树是否为空，如果为空则接下来要访问的节点在栈顶，所以将node赋值为null。如果不为空则
     * 将node赋值为其右子树的值。 循环结束的条件是node不为空或者栈不为空
     */
    private static void inOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            //遍历到当前节点的最后一个左子节点，顺序入栈保存
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //弹出最后一个左子节点
            node = stack.pop();
            list.add(node.val);
            //判断当前节点是否有右子节点，有的话赋值为当前节点，再重复上面的过程（找当前节点的左子节点）
            //没有的话设置为null，去取stack中的当前右子节点的父节点
            if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
    }

    /**
     * 后序遍历:左右根
     */
    private static void postOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder1(root.left);
        postOrder1(root.right);
        list.add(root.val);
    }

    /**
     * 后序遍历
     * 在非递归的实现中要先把根节点入栈，然后再把左子树入栈直到左子树为空，此时停止入栈。
     * 此时栈顶就是需要访问的元素，所以直接取出访问node。在访问结束后，还要判断被访问的节点node是否为栈顶节点的左子树，
     * 如果是的话那么还需要访问栈顶节点的右子树，所以将栈顶节点的右子树取出赋值给node。如果不是的话则说明栈顶节点的右子树已经访问完了，
     * 那么现在可以访问栈顶节点了，所以此时将p赋值为null。判断结束的条件是p不为空或者栈不为空，
     * 若果两个条件都不满足的话，说明所有节点都已经访问完成
     */
    private static void postOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            if (!stack.isEmpty() && node.val == stack.peek().left.val) {
                node = stack.peek().right;
            } else {
                node = null;
            }
        }


    }


}
