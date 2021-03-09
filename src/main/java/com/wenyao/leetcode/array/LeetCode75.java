package com.wenyao.leetcode.array;

/**
 * @author wenyao
 * @Description 颜色分类
 * @Date 2021/3/6 下午2:24
 */
public class LeetCode75 {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;

        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
