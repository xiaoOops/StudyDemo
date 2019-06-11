package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        int sum = 15;
        System.out.println("list = " + FindNumbersWithSum1(array, sum));
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
                    //因为 array 是有序的，所有在有多组满足题意的情况下，直接是最前面的组合的乘积就是最小的了，
                    // 所以直接返回就可以
                    return list;
                }
            }
        }
        return list;
    }


    /**
     * 利用好题干中的已排序数组这个条件，从头尾分别夹逼着来得出答案
     */
    public static ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int last = array.length - 1;
        while (start < last) {
            if (array[start] + array[last] == sum) {
                list.add(array[start]);
                list.add(array[last]);
                break;
            } else if (array[start] + array[last] > sum) {
                //如果大于 sum，说明其中一个数大了，array[start] 已经是最小的数，所以将 last--
                last--;
            } else {
                //如果小于 sum，说明其中一个数小了，array[last] 已经是最大的数，所以将 start++
                start++;
            }
        }
        return list;

    }


}
