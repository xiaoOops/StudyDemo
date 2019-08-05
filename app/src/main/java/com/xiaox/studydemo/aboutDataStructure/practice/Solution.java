package com.xiaox.studydemo.aboutDataStructure.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @date 2019/7/2
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            return o2.compareTo(o1);
        }
    });
    static int count = 0;

    public static void main(String[] args) {

        insert(1);
        insert(5);
        insert(10);
        insert(8);
        insert(7);

        System.out.println("maxHeap = " + maxHeap);
        System.out.println("minHeap = " + minHeap);
    }


    /**
     * 准备2个堆，一个从大到小排序（minHeap） ，一个从小到大排序（maxHeap）
     * 添加数据时，排序后再分别向maxHeap，minHeap插入数据
     * 这样每次插入数据后，满足了两个堆中的数据数目差不超过1，并且maxHeap中的数据均小于minHeap
     */
    public static void insert(Integer num) {
        if (count % 2 == 0) {
            //先将数据存入大顶堆排序，再把最大数取出来放入小顶堆中
            maxHeap.offer(num);
            Integer poll = maxHeap.poll();
            minHeap.offer(poll);
        } else {
            //先将数据存入小顶堆排序，再把最小数取出来放入大顶堆中
            minHeap.offer(num);
            Integer poll = minHeap.poll();
            maxHeap.offer(poll);
        }
        count++;
    }

    public Double getMedian() {
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

}












