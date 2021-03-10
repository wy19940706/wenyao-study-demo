package com.wenyao.leetcode.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

import com.google.common.collect.Maps;

/**
 * @author wenyao
 * @Description
 * @Date 2021/3/9 下午7:24
 */
public class LeetCode519 {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3};
        int[] nums2 = new int[] {1, 3, 2, 4, 3, 6};
        System.out.println(Arrays.toString(getNext(nums1, nums2)));
    }

    public static int[] getNext(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = Maps.newHashMap();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (int num : nums1) {
            result[index++] = map.getOrDefault(num, -1);
        }
        return result;
    }
}
