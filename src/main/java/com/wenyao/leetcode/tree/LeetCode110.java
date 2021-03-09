package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 判断平衡二叉树
 * @Author: wy
 * @CreateDate: 2019/3/28 23:09
 */
public class LeetCode110 {

    public static boolean isBalanced = true;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }

}
