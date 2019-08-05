package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @date 2019/6/24
 * 56.一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {


    public static void main(String[] args) {

        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        findNumsAppearOnce1(array, new int[]{1}, new int[]{1});

    }

    /**
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     */
    private static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
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
     * 要求时间复杂度为O(n),空间复杂度为O(1)
     * 一个数字异或自己都为0，利用这个找出数组中没有重复的数
     * <p>
     * 如果数组中只有一个数字出现了一次，那依次对数组中的每个数字进行异或操作，结果就是那个只出现了一次的数子，因为其他的数字在异或时已经抵消了。
     * 现在数组中有2个数字出现了一次，怎么办？考虑将这个个数组拆分成2个数组，每个数组中都只有一个重复的数字，就可以参照上面的方法解决了。
     * 怎么拆？
     * 1.还是对数组中的数字进行依次异或，结果是2个不重复数字的异或结果，这个结果的二进制肯定有一位为1，我们找到第一个为1的位置，记录下来；
     * 2.以这个二进制位数为1的位置去拆分数组，同样二进制同样位置为1的分到一个数组，其他的到另一个数组，
     * 这样得到的结果就是两个没有重复的数分到不同的数组，同时每个数组里除了这个不重复的数，都是重复的数。
     * 3.参照之前的再依次异或一遍，就可以得到答案
     * <p>
     * 例如：[2,4,3,6,3,2,5,5]
     * 1.从头到尾依次异或的结果用二进制表示是0010，倒数第二位是1,
     * 2.我们以二进制倒数第二位是不是1为依据拆分数组为两个，[2,3,6,3,2] 和[4,5,5]
     * 3......
     */

    private static void findNumsAppearOnce1(int[] array, int[] num1, int[] num2) {
        if (array == null) {
            return;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        int firstBitIs = findFirstBitIs(result);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], firstBitIs))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    /**
     * 找到二进制中最右边为1的index
     * num与0001进行与操作，如果为0，则index=1，不为0，num右移一位index++继续与0001进行与操作，直到为0
     */
    private static int findFirstBitIs(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    /**
     * 判断二进制中右数的indexBit位是否为1
     *
     * @return ture 为1，false 不为1
     */
    private static boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }


}




























