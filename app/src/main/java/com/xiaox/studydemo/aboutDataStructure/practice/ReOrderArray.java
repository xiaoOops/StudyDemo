package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reOrderArray1(array);
        Util.printArray(array);
    }


    public void reOrderArray(int[] array) {
        ArrayList<Integer> oddList = new ArrayList<>();
        ArrayList<Integer> evenList = new ArrayList<>();
        for (Integer integer : array) {
            if (integer % 2 == 0) {
                evenList.add(integer);
            } else {
                oddList.add(integer);
            }
        }
        oddList.addAll(evenList);
        for (int i = 0; i < oddList.size(); i++) {
            array[i] = oddList.get(i);
        }
    }


    /**
     * 这种解法空间复杂度为O(1)，但是不满足奇数和奇数，偶数和偶数之间的相对位置不变这个条件
     * 思路：设置2个指针，begin指向数组首位，end指向末尾，begin向后移动，知道找到偶数，end向前移动，直到找到奇数，
     * 当begin指向偶数，end指向奇数时，交换这两个数，继续移动指针，直到begin的位置大于end，说明已经扫描完整个数组
     */
    private static void reOrderArray1(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            while (array[begin] % 2 != 0) {
                begin++;
            }
            while (array[end] % 2 == 0) {
                end--;
            }
            if (begin < end) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }
    }


    /**
     * 为了保证偶数和偶数，奇数和奇数的相对位置不变
     */
    private static void reOrderArray2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                //前偶后奇交换
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }


}
