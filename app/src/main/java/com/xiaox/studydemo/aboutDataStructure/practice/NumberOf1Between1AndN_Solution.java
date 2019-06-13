package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * 求出1~13的整数中1出现的次数,把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class NumberOf1Between1AndN_Solution {


    /**
     * 简单思路，直接转成string，然后去计算1出现的次数
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while (n != 0) {
            char[] chars = String.valueOf(n).toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    count++;
                }
            }
            n--;
        }
        return count;
    }

}

































