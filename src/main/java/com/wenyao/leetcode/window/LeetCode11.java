package com.wenyao.leetcode.window;

/**
 * 乘最多水的容器
 */
public class LeetCode11 {
    public static void main(String[] args) {

    }

    // 暴力法 时间复杂度：O(n^2) 空间复杂度：O(1)
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    // 双指针法 时间复杂度：O(n) 空间复杂度：O(1)
    public static int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = height[i] < height[j] ? Math.max(maxArea, (j - i) * height[i++])
                    : Math.max(maxArea, (j - i) * height[j--]);
        }
        return maxArea;
    }
}
