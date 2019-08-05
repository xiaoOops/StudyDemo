package com.xiaox.studydemo.aboutDataStructure;

/**
 * @date 2019/7/17
 * 不使用新的变量，交换两个变量的值
 */
public class SwapWithoutThird {

    public void swap(int a, int b) {
        /*
         *  a = a + b;
         *  b = a - b = a + b - b = a;
         *  a = a - b = a + b - a = b;
         */
        a = a + b;
        b = a - b;
        a = a - b;
    }

    public void swap1(int a, int b) {

        /*
         * a = a ^ b;
         * b = a ^ b = a ^ b ^ b = a;
         * a = a ^ b = a ^ b ^ a = b;
         */
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }


}


























