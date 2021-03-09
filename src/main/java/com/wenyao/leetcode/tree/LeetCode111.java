package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 二叉树的最小深度
 * @Date 2021/3/1 下午11:21
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }
}
