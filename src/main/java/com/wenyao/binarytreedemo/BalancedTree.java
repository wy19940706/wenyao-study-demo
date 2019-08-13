package com.wenyao.binarytreedemo;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 平衡二叉树
 * @Author: wy
 * @CreateDate: 2019/3/28 23:09
 */
public class BalancedTree {

    private static boolean isBalanced = true;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isBalancedTree(root));
    }

    private static boolean isBalancedTree(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    private static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;
    }

}
