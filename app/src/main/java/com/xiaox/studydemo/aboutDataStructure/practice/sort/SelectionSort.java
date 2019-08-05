package com.xiaox.studydemo.aboutDataStructure.practice.sort;


/**
 * @date 2019/7/15
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {3, 4, 2, 1, 5, 6, 7, 8, 30, 50, 1, 33, 24, 5, -4, 7, 0};
        selectionSort(array);
        printArray(array);

    }


    /**
     * 核心思想，每次找出最小的数，把它放到数组的前面去
     */
    private static void selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }


    private static void swap(int[] array, int index, int min) {
        int temp = array[index];
        array[index] = array[min];
        array[min] = temp;
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
