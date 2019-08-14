package com.xiaox.studydemo.aboutDataStructure.practice.sort;

/**
 * 插入排序：基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止
 * https://www.cnblogs.com/chengxiao/p/6103002.html
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8, 30, 50, 1, 33, 24, 5, -4, 7, 0};
        insertionSort(array);

    }

    private static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }
        }
        return array;
    }

    private static void swap(int[] array, int index, int min) {
        int temp = array[index];
        array[index] = array[min];
        array[min] = temp;
    }

}
