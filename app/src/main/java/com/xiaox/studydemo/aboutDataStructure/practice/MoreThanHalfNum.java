package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.HashMap;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/6/5
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class MoreThanHalfNum {


    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }


    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        int limit = array.length >> 1;
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        int time = 1;
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                time = 1;
            } else {
                time = map.get(array[i]) + 1;
            }
            map.put(array[i], time);
            if (time > limit) {
                return array[i];
            }
        }
        return 0;
    }
}
