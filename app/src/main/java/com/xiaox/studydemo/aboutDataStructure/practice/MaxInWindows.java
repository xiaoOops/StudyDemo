package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @date 2019/7/2
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class MaxInWindows {

    static PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(num, size);
        System.out.println(list);

    }


    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num.length == 0 || size > num.length || size <= 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num.length - size; i++) {
            for (int j = i; j < i + size; j++) {
                queue.offer(num[j]);
            }
            list.add(queue.peek());
            queue.clear();
        }
        return list;
    }

}





















