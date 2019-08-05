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
        int[] numbers = {3, 2, 3, 0, 2, 3, 6};
        int leng = 7;
        int i = duplicate5(numbers, leng, new int[1]);
        System.out.println(i);
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
     * 利用好题干中的 0 - n-1 这个条件
     * int[] numbers ={2,3,1,0,2,5,3}
     * 从i = 0开始，numbers[0] = 2, 与数组下标不等，交换，数组变成{1,3,2,0,2,5,3}
     * 继续 numbers[0] = 1,与数组下标不等，交换，数组变成{3,1,2,0,2,5,3}
     * 继续 numbers[0] = 3,与数组下标不等，交换，数组变成{0,1,2,3,2,5,3}
     * 继续 numbers[0] = 0,与数组下标相等，i++向后继续遍历
     * 直到 i = 4，numbers[4] = 2,与数组下标不等，交换时发现 numbers[2] = 2，已经有一个2了，发现了第一个重复的数。
     */
    public static boolean duplicate3(int numbers[], int length, int[] duplication) {
        if (numbers.length == 0 || numbers.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    System.out.println(numbers[i]);
                    return true;
                }
                swap(numbers, i);
            }
        }
        return false;
    }

    public static void swap(int numbers[], int index) {
        int temp = numbers[index];
        numbers[index] = numbers[temp];
        numbers[temp] = temp;
    }


    /**
     * 不需要额外的数组或者map来保存，题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，
     * 当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可
     * 同上面的思路，更简单些，但是改变了数组的内容
     * {2,3,1,0,2,5,3}
     */
    public static boolean duplicate1(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int number = numbers[i];
            //防止索引越界，找到对应的索引
            if (number >= length) {
                number -= length;
            }
            if (numbers[number] >= length) {
                duplication[0] = number;
                return true;
            }
            numbers[number] = numbers[number] + length;
        }
        return false;
    }

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
     * 要求：不能修改数组，空间复杂度为 O(1)
     *
     * 把0到n-1的数字从中间数字m分为2部分，即0-m和m+1到n-1，如果从0-m这部分的数字数目超过m，那这部分一定有重复的数字，
     * 否则，另一半一定有重复的数字，继续这个过程，即可找出重复的数字
     */
    public static int duplicate5(int numbers[], int length, int[] duplication) {
        int start = 0;
        int end = length - 1;
        while (end >= start) {
            int mid = (start + end) >> 1;
            int count = countRange(numbers, length, start, mid);
            if (count > (mid - start)) {
                //说明在前半部分
                end = mid;
            } else {
                start = mid + 1;
            }
            //说明二分法已经遍历完了
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

        }


        return -1;
    }

    /**
     * 计算数字出现的次数
     */
    private static int countRange(int[] numbers, int length, int start, int end) {
        if (numbers.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            //说明在范围内
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        return count;
    }

}





























