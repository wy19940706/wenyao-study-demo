package com.wenyao.leetcode.array;

import java.util.PriorityQueue;

import com.alibaba.fastjson.JSON;

/**
 * @Description: 最小的k个数
 * @Author: wy
 * @CreateDate: 2019/3/20 13:03
 */
public class SwordToOffer44 {
    public static void main(String[] args) {
        int[] array = new int[] {3, 21, 5, 4, 2, 6};
        System.out.println(JSON.toJSONString(getLeastNumsOfK(array, 4)));
    }

    private static int[] getLeastNumsOfK(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            return new int[0];
        }
        // 优先级队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        int count = 0;
        while (!queue.isEmpty()) {
            result[count++] = queue.poll();
        }
        return result;
    }

}
