package com.wenyao.leetcode.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wenyao
 * @Description 下一个更大元素II
 * @Date 2021/3/9 下午10:56
 */
public class LeetCode503 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] {1, 3, 1})));
    }

    // 输入: [1,2,1]
    // 输出: [2,-1,2]
    // 解释: 第一个 1 的下一个更大的数是 2；
    // 数字 2 找不到下一个更大的数；
    // 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Deque<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < length * 2 - 1; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peek()] < nums[i % length]) {
                result[linkedList.pop()] = nums[i % length];
            }
            linkedList.push(i % length);
        }
        return result;
    }

}
