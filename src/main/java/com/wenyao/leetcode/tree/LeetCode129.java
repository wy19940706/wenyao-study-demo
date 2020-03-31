package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 求根到叶子节点数字总和
 * @Author: wy
 * @CreateDate: 2019/3/14 17:25
 */
public class LeetCode129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(sumNumbers(root));
    }

    private static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private static int helper(TreeNode root, int baseLevel) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data + baseLevel;
        }
        int nextBaseLevel = (root.data + baseLevel) * 10;
        int leftSubTreeSum = helper(root.left, nextBaseLevel);
        int rightSubTreeSum = helper(root.right, nextBaseLevel);
        return leftSubTreeSum + rightSubTreeSum;
    }
}
