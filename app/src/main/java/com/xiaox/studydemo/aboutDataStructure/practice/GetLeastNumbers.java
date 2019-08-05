package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @date 2019/7/4
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 */
public class GetLeastNumbers {


    public static void main(String[] args) {

        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        GetLeastNumbers(input, 4);
    }

    /**
     * 简单解法，使用api
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k <= 0 || k > input.length) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    /**
     * 使用PriorityQueue
     */
    public static ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k <= 0 || k > input.length) {
            return list;
        }
        //创建一个从小到大排序的PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (queue.size() == k && queue.peek() > input[i]) {
                queue.poll();
                queue.offer(input[i]);
            } else if (queue.size() < k) {
                queue.offer(input[i]);
            }
        }
        list.addAll(queue);
        return list;
    }

}
