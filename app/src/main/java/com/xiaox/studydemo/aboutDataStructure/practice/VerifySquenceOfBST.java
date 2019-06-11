package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 *
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        int[] sequence = {4, 8, 6, 12, 16, 14, 10};
        VerifySquenceOfBST(sequence);
    }


    /**
     *  二叉搜索树:或者是一棵空树;若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     *  若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
     *
     *  思路：
     *  先判断是否有左子树，有的话找到根结点的左孩子，记录下来，然后再遍历右子树，用一个index记录，符合二叉搜索树则+1，最后与树的长度比较，相等则认为是符合结果的
     *
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        int index = 0;
        int lChildIndex = 0;//判断搜索树是否有左子树的index
        for (int i = 0; i < sequence.length; i++) {
            //先判断是否有左子树
            if (sequence[i] < sequence[sequence.length - 1]) {
                //如果有结点小于根结点，则认为是有左子树
                lChildIndex = i;
            } else {
                //一直遍历到当前结点大于根结点，认为左子树遍历结束了
                index = i;
                break;
            }
        }
        //遍历右子树
        for (int i = lChildIndex; i < sequence.length; i++) {
            if (sequence[i] > sequence[sequence.length - 1]) {
                index++;
            }
        }
        return index + 1 == sequence.length;
    }


    // TODO: 2019/6/11 利用递归实现
}

























