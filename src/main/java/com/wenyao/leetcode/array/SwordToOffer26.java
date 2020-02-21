package com.wenyao.leetcode.array;

/**
 * @Description: 在原地删除有序数组中的重复元素，并返回新数组的长度
 * @Author: wy
 * @CreateDate: 2019/5/19 13:45
 */
public class SwordToOffer26 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0, cur = 0, n = nums.length;
        while (cur < n) {
            if (nums[pre] == nums[cur]) {
                cur++;
            } else {
                ++pre;
                nums[pre] = nums[cur];
                cur++;
            }
        }
        return pre + 1;
    }
}
