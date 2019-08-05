package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 *
 */
public class MinNumberInRotateArray {


    public static void main(String[] args) {
        int[] array = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        int[] array1 = {2, 1, 2, 2, 2};
        int i = minNumberInRotateArray2(array1);
        System.out.println(i);
    }


    public int minNumberInRotateArray(int[] array) {
        int min = 0;
        if (array == null || array.length == 0) {
            return min;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                min = array[i + 1];
                break;
            }

        }
        return min;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     * <p>
     * 二分查找法的变形：数组第一个数总是小于最后一个数
     * {3,4,5,6,7,8,1,2}
     * {6,7,1,2,3,4,5,6}
     */
    private static int minNumberInRotateArray1(int[] array) {

        int start = 0;
        int last = array.length - 1;
        int result = 0;
        if (array.length == 0) {
            return result;
        }
        while (array[start] >= array[last]) {
            if (start + 1 == last) {
                //说明找到了
                result = last;
                break;
            }
            //二分法，先从中间找
            result = (start + last) / 2;
            if (array[start] <= array[result]) {
                // 说明要找的在后半段，从后半段开始找
                start = result;
            } else {
                last = result;
            }
        }
        return array[result];
    }

    /**
     * [2, 1, 2, 2, 2] 也可以看做是 [0,2,2,2,2]的旋转数组，该如何处理？
     * <p>
     * 当array[start] == array[last] == array [middle] 时，只能顺序查找
     */
    private static int minNumberInRotateArray2(int[] array) {

        int start = 0;
        int last = array.length - 1;
        int middle = 0;
        if (array.length == 0) {
            return middle;
        }
        while (array[start] >= array[last]) {
            if (start + 1 == last) {
                //说明找到了
                middle = last;
                break;
            }
            //二分法，先从中间找
            middle = (start + last) / 2;
            //如果出现题干中的情况，只能顺序查找了
            if (array[start] == array[last] && array[start] == array[middle]) {
                return minInOrder(array, start, last);
            }
            if (array[start] <= array[middle]) {
                // 说明要找的在后半段，从后半段开始找
                start = middle;
            } else {
                last = middle;
            }
        }
        return array[middle];
    }

    private static int minInOrder(int[] array, int start, int last) {
        int result = array[start];
        for (int i = start; i <= last; i++) {
            if (array[i] < array[start]) {
                result = array[i];
            }

        }
        return result;
    }


}































