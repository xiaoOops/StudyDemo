package com.xiaox.studydemo.aboutDataStructure.practice.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @date 2019/8/16
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 递归实现
     */
    private static void quickSort(int[] arrays, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arrays, startIndex, endIndex);
        // 根据基准元素，分成两部分递归排序
        quickSort(arrays, startIndex, pivotIndex);
        quickSort(arrays, pivotIndex + 1, endIndex);
    }

    /**
     * 循环实现
     */
    @SuppressWarnings("all")
    public static void quickSort1(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);
        // 循环结束条件：栈为空时结束
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 得到基准元素位置
            int pivotIndex = partition(arr, param.get("startIndex"), param.get("endIndex"));
            // 根据基准元素分成两部分, 把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex + 1 < param.get("endIndex")) {
                Map<String, Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex", pivotIndex + 1);
                rightParam.put("endIndex", param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    private static int partition(int[] arrays, int startIndex, int endIndex) {
        //设置第一个位置为基准元素位置
        int pivot = arrays[startIndex];
        //赋值左右指针
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //先检查右指针的值，如果大于等于基准元素就向左移动
            while (left < right && arrays[right] >= pivot) {
                right--;
            }
            //再检查左指针的值，如果小于等于基准元素就向右移动
            while (left < right && arrays[left] <= pivot) {
                left++;
            }
            //交换左右指针指向的值
            if (left < right) {
                swap(arrays, left, right);
            }
        }
        //在左右指针重合时交换与基准元素的值
        swap(arrays, startIndex, left);
        return left;
    }


    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
