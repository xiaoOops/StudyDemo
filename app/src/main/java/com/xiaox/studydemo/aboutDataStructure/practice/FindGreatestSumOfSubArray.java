package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给一个数组，返回它的最大连续子序列的和，子向量的长度至少是1
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        findGreatestSumOfSubArray(array);
    }

    /**
     * 简单粗暴：直接从第一个加到最后一个去比较
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        ArrayList<Integer> listA = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                listA.add(sum);
            }
        }
        Collections.sort(listA);
        return listA.get(listA.size() - 1);
    }

    /**
     * 使用动态规划
     */
    public static int findGreatestSumOfSubArray1(int[] array) {
        /*
         *  如数组[6, -3, -2, 7, -15, 1, 2, 2]
         *  初始状态：
         *      F（0）=6
         *      result=6
         *      i=1：
         *      F（1）=max（F（0）-3，-3）=max（6-3，3）=3
         *      result=max（F（1），result）=max（3，6）=6
         *      i=2：
         *      F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
         *      result=max（F（2），result）=max（1，6）=6
         *      i=3：
         *      F（3）=max（F（2）+7，7）=max（1+7，7）=8
         *      result=max（F（2），result）=max（8，6）=8
         *      i=4：
         *      F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
         *      result=max（F（4），result）=max（-7，8）=8
         *      以此类推
         *      最终result的值为8
         */
        int sum = 0;
        int result = array[0];
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            result = Math.max(sum, result);
        }

        return result;
    }
}
