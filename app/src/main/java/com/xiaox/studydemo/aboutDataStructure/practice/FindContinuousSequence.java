package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;

/**
 * @Description: 找出所有和为S的连续正数序列, 例如：100的和连续序列有9~16，18~22..
 * @date 2019/6/25
 * @author:xiaox
 */
public class FindContinuousSequence {


    /**
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * <p>
     * 相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int pStart = 1;//开始的指针
        int pEnd = 2;//结束的指针
        while (pStart < pEnd) {
            //根据等差数列求和公式，计算开始到结束的和,(a0+an)*n/2
            int result = (pStart + pEnd) * (pEnd - pStart + 1) / 2;
            if (result == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = pStart; i <= pEnd; i++) {
                    arrayList.add(i);
                }
                list.add(arrayList);
                //开始的指针＋1，继续找
                pStart++;
            } else if (result < sum) {
                //和比sum小，将结束的指针后移
                pEnd++;
            } else {
                //和比sum大，将开始的指针后移
                pStart++;
            }
        }
        return list;
    }
}





























