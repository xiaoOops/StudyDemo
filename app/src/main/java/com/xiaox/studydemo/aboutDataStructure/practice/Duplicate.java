package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 *
 * @date 2019/6/29
 * @author:xiaox
 */
public class Duplicate {


    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 1, 4};
        int leng = 5;

    }

    /**
     * @param numbers     an array of integers
     * @param length      the length of array numbers
     * @param duplication 这里要特别注意~返回任意重复的一个，赋值duplication[0]
     * @return true if the input is valid, and there are some duplications in the array number otherwise false
     * <p>
     * 利用ArrayList，但是好像length这个条件用不上？,而且需要使用额外空间
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean flag = false;
        if (numbers == null || numbers.length > length) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                flag = true;
                break;
            } else {
                list.add(numbers[i]);
            }
        }
        return flag;
    }


    /**
     * 不需要额外的数组或者map来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，
     * 当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可
     */
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        boolean flag = false;
        if (numbers == null || numbers.length > length) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                flag = true;
                break;
            } else {
                list.add(numbers[i]);
            }
        }
        return flag;
    }


}
