package com.wenyao.swordtooffer.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 平衡二叉树
 * @Author: wy
 * @CreateDate: 2019/3/26 22:38
 */
public class SwordToOffer54 {

    private boolean isBalanced = true;

    public static void main(String[] args) {

    }

    private boolean isBalancedTree(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null || !isBalanced) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }
}
