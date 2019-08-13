package com.wenyao.leetcode.Freq5;

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
        System.out.println(result);
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
            find(nums,i+1,len-1,nums[i]);
        }
        return result;
    }

    private static void find(int[] nums, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (nums[l] + nums[r] + target == 0) {
                List<Integer> ans = new ArrayList<>();
                ans.add(target);
                ans.add(nums[l]);
                ans.add(nums[r]);
                result.add(ans);
                while (l < r && nums[l] == nums[l + 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r - 1]) {
                    r--;
                }
                l++;
                r--;
            } else if (nums[l] + nums[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
}
