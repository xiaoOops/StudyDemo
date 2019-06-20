package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.Stack;

/**
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * @date 2019/6/20
 * @author:xiaox
 */
public class MinStack {

    private Stack<Integer> normalStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (minStack.isEmpty() || minStack.peek() < node) {
            minStack.push(node);
        }
        normalStack.push(node);
    }

    public void pop() {
        if(minStack.isEmpty()||normalStack.isEmpty()) {
            return;
        }
        if (minStack.pop().equals(normalStack.pop())) {
            minStack.pop();
        }
        normalStack.pop();
    }

    public int top() {
        return normalStack.pop();
    }

    public int min() {
        return minStack.pop();
    }

}












