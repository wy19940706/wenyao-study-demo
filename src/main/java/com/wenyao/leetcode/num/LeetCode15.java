package com.wenyao.leetcode.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 求满足求和为0的三个数
 * @Author: wy
 * @CreateDate: 2019/1/9 17:40
 */
public class LeetCode15 {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1, 2, 4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(threeSumOne(nums));
        System.out.println(result);
    }

    public static List<List<Integer>> threeSumOne(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return result;
        }
        Arrays.sort(nums); // 先进行排序
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重}
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // 去重
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // 去重
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


    private static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            find(nums, i + 1, len - 1, nums[i]);
        }
        return result;
    }

    private static void find(int[] nums, int begin, int end, int target) {
        int left = begin;
        int right = end;
        while (left < right) {
            if (nums[left] + nums[right] + target == 0) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(target);
                tempList.add(nums[left]);
                tempList.add(nums[right]);
                result.add(tempList);
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else if (nums[left] + nums[right] + target < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
