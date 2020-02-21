package com.wenyao.leetcode.num;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 求数组中第k大的数
 */
public class LeetCode215 {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
