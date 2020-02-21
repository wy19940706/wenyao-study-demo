package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 翻转二叉树
 */
public class LeetCode226 {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }
}
