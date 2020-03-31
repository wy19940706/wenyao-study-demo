package com.wenyao.leetcode.dp;

/**
 * 最长公共子序列(不一定连续)&&最长公共子串
 */
public class LeetCode1143 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 5, 4};
        int[] nums2 = new int[] {8, 1, 6, 2, 3, 4};
        System.out.println(lcs(nums1, nums2));
        String text1 = "abcdef";
        String text2 = "bdef";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    // 时间复杂度：O(m*n) 空间复杂度：O(m*n)
    private static int lcs(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return 0;
        }
        if (nums2 == null || nums2.length == 0) {
            return 0;
        }
        // dp(i,j)是nums1前i个元素与nums2前j个元素的最长公共子序列
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }

    // 时间复杂度：O(m*n) 空间复杂度：O(m*n)
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0) {
            return 0;
        }
        if (text2 == null || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
