package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/7/16
 * 一根长度为N的绳子，把绳子剪成M段(m、n都是整数，且m>1,n>1), 每段绳子的长度记为k1，k2，k3....km，
 * 请问k1*k2*k3*km可能的最大值是多少？
 * <p>
 * 如：当绳子长度是8，我们把它剪成长度分别是2,3,3的三段，此时的最大乘积是18
 */
public class MaxProductAfterCut {

    public static void main(String[] args){
        System.out.println(sulotion(17));
    }


    /**
     * 贪婪算法：
     * 将绳子尽可能的分割成更多的3个长度的段，当3个长度的段分割不完时，再考分割成2个长度的段，只有这样的分法，才能得到乘积最大值
     */
    public static int sulotion(int length) {
        int[] result = {1, 2, 4};
        if (length == 1 || length == 2) {
            return result[0];
        } else if (length == 3) {
            return result[1];
        } else if (length == 4) {
            return result[2];
        }
        int threeCount = length / 3;
        int otherCount = 1;
        if (length % 3 != 0) {
            otherCount = length % 3;
        }
        return (int)Math.pow(3,threeCount) * otherCount;
    }


}
