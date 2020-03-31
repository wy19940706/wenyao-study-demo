package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 路径总和
 */
public class LeetCode112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.data;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
