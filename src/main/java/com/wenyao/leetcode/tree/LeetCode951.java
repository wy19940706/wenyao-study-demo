package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 翻转等价二叉树
 */
public class LeetCode951 {

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
                || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
