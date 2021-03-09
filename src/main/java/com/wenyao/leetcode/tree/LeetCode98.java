package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 验证二叉搜索树
 * @Author: wy
 * @CreateDate: 2019/3/12 22:34
 */
public class LeetCode98 {
    public static void main(String[] args) {

    }

    private static boolean validBST(TreeNode root) {
        return validBST(root, null, null);
    }

    private static boolean validBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        if (max != null && root.data >= max.data) {
            return false;
        }

        return validBST(root.left, min, root) && validBST(root.right, root, max);
    }

}
