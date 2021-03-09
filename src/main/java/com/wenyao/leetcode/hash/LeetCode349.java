package com.wenyao.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wenyao
 * @Description
 * @Date 2021/3/7 上午11:48
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> parent = new HashSet<>();
        Set<Integer> child = new HashSet<>();
        for (int num : nums1) {
            parent.add(num);
        }
        for (int num : nums2) {
            if (parent.contains(num)) {
                child.add(num);
            }
        }
        int[] res = new int[child.size()];
        int index = 0;
        for (int num : child) {
            res[index++] = num;
        }
        return res;
    }
}
