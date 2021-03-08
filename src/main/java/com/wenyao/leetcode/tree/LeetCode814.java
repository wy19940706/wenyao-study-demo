package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 二叉树剪枝 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树
 */
public class LeetCode814 {

    public static TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    // 包含一
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
