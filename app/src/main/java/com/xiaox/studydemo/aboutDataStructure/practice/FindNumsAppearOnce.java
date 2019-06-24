package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @date 2019/6/24
 */
public class FindNumsAppearOnce {


    public static void main(String[] args) {

        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        FindNumsAppearOnce(array, new int[]{1}, new int[]{1});

    }

    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     */
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer count = map.get(array[i]);
                map.put(array[i], count + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }


    /**
     * https://www.nowcoder.com/profile/2777550/codeBookDetail?submissionId=18661437
     */
    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2)
            return;
        int temp = 0;
        for (int i = 0; i < array.length; i++)
            temp ^= array[i];

        int indexOf1 = findFirstBitIs(temp);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], indexOf1))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    public int findFirstBitIs(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    public boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }


}




























