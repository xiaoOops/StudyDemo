package com.xiaox.studydemo.aboutSort;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/5/15
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] unSort = {9, 8, 7, 11, 6, 4, 2, 3, 8, 7};

        bubbleSort(unSort);
    }

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    private static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int temp;
        for (int i = 0; i < array.length; i++) {
            //每一遍的第一层循环完最后一个数字就是最大的了，
            // 所以再次循环时不用去比最后一位
            for (int j = 0; j < array.length - 1 - i; j++) {
                //如果后一位数字比现在的小，就交换位置
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
