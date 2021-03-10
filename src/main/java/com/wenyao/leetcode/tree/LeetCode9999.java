package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 二叉树的最大值
 * @Date 2021/3/10 下午10:32
 */
public class LeetCode9999 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        TreeNode maxOfTree = getMaxOfTree(root);
        System.out.println(maxOfTree.data);
    }

    public static TreeNode getMaxOfTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode maxLeftNode = getMaxOfTree(root.left);
        TreeNode maxRightNode = getMaxOfTree(root.right);
        return max(root, max(maxLeftNode, maxRightNode));
    }

    private static TreeNode max(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return left.data > right.data ? left : right;
    }
}
