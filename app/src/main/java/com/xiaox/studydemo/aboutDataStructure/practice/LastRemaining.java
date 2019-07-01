package com.xiaox.studydemo.aboutDataStructure.practice;

/**
 * @Description: 首先, 让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * @date 2019/6/28
 * @author:xiaox
 */
public class LastRemaining {


    public static void main(String[] arg) {
        int m = 4;
        int n = 10;
        LastRemaining_Solution(n, m);
    }


    /**
     * 用数组来模拟环,用一个step记录数过的数，数到m就清0，同时记录下来在环中的位置，下次循环跳过该位置（模拟该小朋友退出游戏）
     * 用一个count记录小朋友的数量，每次数到m就-1，小于n时就退出循环
     */
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int[] array = new int[n];
        int i = -1;//数组的指针
        int step = 0;
        int count = n;
        while (count > 0) {
            i++;
            if (i == n) {//模拟数组是一个环
                i = 0;
            }
            if (array[i] == -1) {//剔除数到m的小朋友

                continue;
            }
            step++;//被剔除的小朋友不能数了，所以在之后++
            if (step == m) {
                step = 0;
                array[i] = -1;//记录位置
                count--;//小朋友数量-1
            }
        }
        //返回跳出循环时的i,即最后一个被设置为-1的元素
        return i;
    }
}






























