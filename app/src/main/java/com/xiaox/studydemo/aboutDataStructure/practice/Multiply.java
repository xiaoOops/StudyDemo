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
        int result = getResult(A, 0);
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
     * 计算数组乘积
     *
     * @param a     数组
     * @param index 从数组第几个索引开始计算乘积
     */
    private static int getResult(int[] a, int index) {

        if (index < a.length - 1) {
            return a[index] * getResult(a, index + 1);
        } else {
            //递归到数组最后一个元素了
            return a[index];
        }
    }
    /**
     *    上面的递归一层层展开后大体是这样的：
     *
     *    arr[0] * sum(1,arr)
     *    arr[0] * arr[1] * sum(2,arr)
     *    arr[0] * arr[1] * arr[2] * sum(3, arr)
     *    arr[0] * arr[1] * arr[2] * arr[3] * sum(4, arr)
     *    arr[0] * arr[1] * arr[2] * arr[3] * arr[4]
     */


}
