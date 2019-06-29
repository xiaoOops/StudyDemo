package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @date 2019/6/29
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class Multiply {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        //multiply(A);
        int result = getResult(A, 3);
        System.out.println("result = " + result);
    }

    public static int[] multiply(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int result = 1;
            for (int j = i; j > 0; j--) {
                result *= a[j];
            }
            b[i] = result;
        }
        return b;
    }

    /**
     * 怎么理解递归？？？
     */
    private static int getResult(int[] A, int index) {
        if (index == 0) {
            return A[0];
        }
        return getResult(A, index) * getResult(A, index - 1);
    }


}
