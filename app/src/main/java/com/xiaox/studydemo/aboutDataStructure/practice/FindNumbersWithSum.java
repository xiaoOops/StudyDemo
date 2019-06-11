package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5};
        int sum = 5;
        System.out.println("list = " + FindNumbersWithSum(array, sum));
    }


    /**
     * 用sum - array[0] ,再遍历剩下的...
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] == sum - array[i]) {
                    list.add(array[i]);
                    list.add(array[j]);
                    break;
                }
            }
        }
        return list;
    }


}
