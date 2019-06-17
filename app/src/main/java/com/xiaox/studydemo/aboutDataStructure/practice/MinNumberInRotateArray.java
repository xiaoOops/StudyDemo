package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class MinNumberInRotateArray {


    public static void main(String[] args) {
        //154
        int[] array = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        int i = minNumberInRotateArray1(array);
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
     * 二分查找法的变形：数组第一个数总是小于最后一个数
     * {3,4,5,6,7,8,1,2}
     * {6,7,1,2,3,4,5,6}
     */
    public static int minNumberInRotateArray1(int[] array) {

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

}































