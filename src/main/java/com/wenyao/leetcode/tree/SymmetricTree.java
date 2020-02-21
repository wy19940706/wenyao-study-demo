package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 对称二叉树
 * @Author: wy
 * @CreateDate: 2019/3/28 23:21
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(isSymmetricTree(root));
    }

    private static boolean isSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    private static boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.data == right.data && isSym(left.right, right.left) && isSym(left.left, right.right);
    }


}
