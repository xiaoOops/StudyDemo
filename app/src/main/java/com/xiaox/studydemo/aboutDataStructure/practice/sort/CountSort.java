package com.xiaox.studydemo.aboutDataStructure.practice.sort;

/**
 * @date 2019/7/12
 * 计数排序
 */
public class CountSort {


    public static void main(String[] args) {
        // 输入元素均在 [0, 10) 这个区间内
        int[] arr = new int[]{5, 4, 6, 7, 5, 1, 0, 9, 8, 1};
        int[] arr1 = new int[]{-3, 15, -12, 0, 48, 41, -8, 23, 33, 33};
        countSort1(arr1);
        printArray(arr1);
    }


    /**
     * 假设 n 个输入元素都是 0 到 k 区间内的一个整数，其中 k 为某个整数
     * 创建一个长度为 k+1 的数组 count[]，它的 count[i] 的值对应输入数组中 i 出现的次数。
     * 通过遍历一次输入数组并统计每个元素出现次数，最后遍历 count[] 输出
     */
    private static void countSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            //用count记录arr中每个数出现的次数
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            //遍历arr，如果在count中出现了，就填进arr中，并且索引++，count--
            while (count[i] > 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }


    /**
     * 假如我们存在负数的输入，或者我们也不确定输入元素的具体范围是多少，又该怎么变通呢？
     * <p>
     * 只需要多遍历一次数组，找到元素的最大值 max 和最小值 min，然后依旧创建一个长度为 max - min + 1 长度的数组，
     * 其中 min 是可能为负数的。然后我们引入一个变量 offset 来修正数值 i 在计数数组 count[] 中的正确位置
     */
    private static void countSort1(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int[] count = new int[max - min + 1];
        int offset = 0 - min;
        for (int i = 0; i < arr.length; i++) {
            //用count记录arr中每个数出现的次数
            count[arr[i] + offset]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index] = i - offset;
                index++;
                count[i]--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}




































