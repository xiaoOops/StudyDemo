package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.Stack;

/**
 * @version V1.0
 * @Title: Loan
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @date 2019/5/31
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class TwoStackImplQueue {

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.pop();
        solution.pop();
        solution.push(4);

        System.out.println("stack1 =" + solution.stack1);
        System.out.println("stack2 =" + solution.stack2);

    }

    /**
     * 一个栈用作入队列，一个栈用作出队列
     */
    public static class Solution {
        public Stack<Integer> stack1 = new Stack<Integer>();
        public Stack<Integer> stack2 = new Stack<Integer>();

        /**
         * stack1 作为队列头部
         */
        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new IllegalArgumentException("stack is empty");
            }
            // stack2 作为队列尾部，当需要pop的时候，从stack1 逆序压入到 stack2中，再从stack2中出栈
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
