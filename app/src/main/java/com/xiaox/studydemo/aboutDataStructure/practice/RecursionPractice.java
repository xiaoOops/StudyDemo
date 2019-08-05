package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/7/17
 * 递归练习
 */
public class RecursionPractice {

    public static void main(String[] args) {
        System.out.println(getExponent(2, 5));
    }


    /**
     * 求base的exponent次方
     * 需要考虑边界问题：base是否为0？exponent是否是负数？是否是0？
     * 这里为了练习递归，只考虑测试用例都是正常值，即base是正整数，exponent是正整数
     * 分析可以得出以下公式
     *      |  a的n/2次方 *  a的n/2次方   (n为偶数）
     * aⁿ = |
     *      |  a的(n-1)/2次方 * a的(n-1)/2次方 * n   (n为奇数)
     * @param base     底数
     * @param exponent 指数
     */
    private static int getExponent(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        int result = getExponent(base, exponent >> 1);
        result *= result;
        //如果exponent 是奇数，最后还要乘上base
        if (exponent % 2 != 0) {
            result *= base;
        }
        return result;
    }


}
