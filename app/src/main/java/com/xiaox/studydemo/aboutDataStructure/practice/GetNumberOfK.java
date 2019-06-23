package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.Arrays;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author:xiaox
 */
public class GetNumberOfK {

    public static void main(String[] args) {

        int[] array = {1, 3, 3, 3, 3, 4, 5};
        int k = 2;
        getNumberOfK(array, k);

    }

    public static int getNumberOfK(int[] array, int k) {
        int index = Arrays.binarySearch(array, k);
        int count = 0;
        if (index < 0) {
            return count;
        }
        for (int i = index; i < array.length; i++) {
            if (array[i] != k) {
                break;
            }
            count++;
        }
        for (int i = index; i >= 0; i--) {
            if (array[i] != k) {
                break;
            }
            count++;
        }
        return count - 1;
    }


}
