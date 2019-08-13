package com.wenyao.leetcode.Freq5;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Description: 求数据流的中位数
 * @Author: wy
 * @CreateDate: 2019/5/20 17:20
 */
public class MedianFinder {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void addNum(Integer num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        System.out.println(findMedian());
        addNum(3);
        System.out.println(findMedian());
    }
}
