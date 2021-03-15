package com.wenyao.leetcode.array;

/**
 * @author wenyao
 * @Description 寻找旋转排序数组中的最小值 II
 * @Date 2021/3/16 上午12:36
 */
public class LeetCode154 {

    // 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    // ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    // 请找出其中最小的元素。
    // 注意数组中可能存在重复的元素。
    // 输入: [1,3,5]
    // 输出: 1
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {// 最小值在右边
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }

}
