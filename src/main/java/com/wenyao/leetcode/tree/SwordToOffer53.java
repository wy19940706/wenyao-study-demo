package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 二叉树的深度
 * @Author: wy
 * @CreateDate: 2019/3/26 22:56
 */
public class SwordToOffer53 {
    public static void main(String[] args) {

    }

    private static int lengthOfTree(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(lengthOfTree(root.left), lengthOfTree(root.right));
    }
}
