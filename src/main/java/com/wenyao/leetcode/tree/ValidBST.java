package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description
 * @Date 2021/3/1  下午3:50
 */
public class ValidBST {

    public static void main(String[] args) {

    }

    public static boolean valicBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return valicBST(root, null, null);
    }

    private static boolean valicBST(TreeNode root, TreeNode min, TreeNode max) {
        return true;
    }
}