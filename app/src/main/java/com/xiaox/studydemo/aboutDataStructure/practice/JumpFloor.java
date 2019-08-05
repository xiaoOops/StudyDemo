package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/6/4
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class JumpFloor {

    public static void main(String[] args) {
        System.out.println("result = " + JumpFloor(5));

    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     * <p>
     * 找规律的解法，f(1) = 1, f(2) = 2, f(3) = 3, f(4) = 5，  可以总结出f(n) = f(n-1) + f(n-2)的规律
     * <p>
     * 前提只有 一次 1阶或者2阶的跳法。
     * a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
     * b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
     * c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
     * d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
     * e.可以发现最终得出的是一个斐波那契数列：
     *
     * <p>
     *        | 1, (n=1)
     * f(n) = | 2, (n=2)
     *        | f(n-1)+f(n-2) ,(n>2,n为整数)
     */
    public static int JumpFloor(int target) {
        if (target <= 0) {
            return 1;
        }
        if (target == 1) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }


    /**
     * 当n太大时，递归解法会有会有严重的效率问题：
     * 1.会出现大量重复的计算，如f(10)=f(9)+f(8); f(9)=f(8)+f(7),f(8)=f(7)+f(6)...递归时f(8),f(7)...都存在重复计算
     * 实际上递归的时间负责度是以n的指数形式递增的
     * 2.每一次的函数调用，都会消耗内存堆的容量，太深的递归调用，可能会造成栈溢出
     * <p>
     * 可以从前往后计算，计算出f(0),f(1),得出f(2),再计算出f(3),以此类推，就可以计算出f(n)了
     */
    public static int JumpFloor1(int target) {
        if (target < 0) {
            return 0;
        }
        int[] result = {1, 2};
        if (target < 2) {
            return result[target];
        }
        int f1 = 2;
        int f0 = 1;
        int fn = 0;
        for (int i = 2; i <= target; i++) {
            fn = f0 + f1;
            //先把第二个加数赋值给第一个加数
            f0 = f1;
            //再把结果赋值给第二个加数
            f1 = fn;
        }
        return fn;
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上m级（m <= n）求该青蛙跳上一个n级的台阶总共有多少种跳法
     * f(1) = 1
     * f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
     * f(3) = f(3-1) + f(3-2) + f(3-3)
     * ...
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
     * 说明：
     * 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
     * 2）n = 1时，只有1种跳法，f(1) = 1
     * 3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
     * 4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
     * 那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
     * 因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
     * 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
     * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     * 6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
     * f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     * f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     * 可以得出：
     * f(n) = 2*f(n-1)
     * 7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
     *        | 1       ,(n=0 )
     * f(n) = | 1       ,(n=1 )
     *        | 2*f(n-1),(n>=2)
     */
    public static int JumpFloor2(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloor2(target - 1);
    }

}
