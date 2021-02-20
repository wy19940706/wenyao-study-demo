package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 二叉树剪枝
 */
public class LeetCode814 {

    public static TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private static boolean containsOne(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.data == 1 || left || right;
    }
}
