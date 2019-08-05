package com.xiaox.studydemo.aboutDataStructure;

import java.util.Stack;

/**
 * @date 2019/7/22
 * 逆序一个栈，例如一个栈从栈顶到栈底的元素分别为1,2,3,4,5
 * 要求使用递归实现栈的元素栈底到栈顶元素顺序为5,4,3,2,1 ，不能使用其他数据结构
 */
public class ReverseStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }


    private static void reverseStack(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(i);
    }


    private static Integer getAndRemoveLastElement(Stack<Integer> stack) {
        //弹出栈顶元素
        int result = stack.pop();
        //弹出元素后如果栈为空，则返回该元素
        if (stack.isEmpty()) {
            return result;
        } else {
            //不为空时，则递归。此时栈为原栈弹出栈顶元素后的一个变化的栈。
            //当递归到栈底元素时，将栈顶元素返回并赋值给变量last
            int last = getAndRemoveLastElement(stack);
            //递归结束。将除栈底元素的其他元素按原先顺序依次入栈。
            //此时的栈与原栈的区别是：栈底元素被移除
            stack.push(result);
            //返回原栈底元素
            return last;
        }
    }

}
