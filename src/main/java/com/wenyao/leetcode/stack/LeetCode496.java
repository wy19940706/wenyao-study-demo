package com.wenyao.leetcode.stack;

import java.util.Map;
import java.util.Stack;

import com.google.common.collect.Maps;

/**
 * @author wenyao
 * @Description
 * @Date 2021/3/9 下午10:50
 */
public class LeetCode496 {

    // 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
    // 输出: [-1,3,-1]
    // 解释:
    // 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    // 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    // 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
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
