package com.xiaox.studydemo.aboutStack;

import java.util.Stack;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/5/17
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class StackDemo {

    public static int index;

    /**
     * stack 先进后出(FILO, First In Last Out)
     */
    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
        integers.push(4);
        // 栈底 [1,2,3,4] 栈顶
        reverse(integers);
        System.out.println(integers);
    }


    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        //第一次 i = 1，stack = [2,3,4]
        //第二次 i = 2，stack = [3,4]
        //第三次 i = 3，stack = [4]
        //第四次 i = 4，stack = []
        reverse(stack);
        stack.push(i);
    }

    /**
     * 这个函数就是删除栈底元素并返回这个元素
     *
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            //第一次 result = 4，stack = [1,2,3]
            //第二次 result = 3，stack = [1,2]
            //第三次 result = 2，stack = [1]
            //第四次拿到的是 last = 1，stack = []
            stack.push(result);
            return last;
        }
    }

    //=================================================================================================================
    /**
     * 设计一个有getMin功能的栈
     */
    private Stack<Integer> stackData = new Stack<Integer>();
    private Stack<Integer> stackMin = new Stack<Integer>();


    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum < getmin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is Empty.");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getmin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }

}
