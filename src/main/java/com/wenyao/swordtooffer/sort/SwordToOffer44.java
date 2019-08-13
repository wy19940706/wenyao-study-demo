package com.wenyao.swordtooffer.sort;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description: 最小的k个数
 * @Author: wy
 * @CreateDate: 2019/3/20 13:03
 */
public class SwordToOffer44 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 21, 5, 4, 2, 6};
        System.out.println(JSON.toJSONString(getLeastNumsOfK(array, 4)));
    }

    private static List<Integer> getLeastNumsOfK(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            return Lists.newArrayList();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return Lists.newArrayList(queue);
    }

}
