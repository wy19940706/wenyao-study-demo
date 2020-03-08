package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 二叉树展开为链表
 */
public class LeetCode114 {
    public static void main(String[] args) {

    }

    public static void flatten(TreeNode root) {
        while (root != null) {
            // 如果左子树为空，直接去找右子树了
            if (root.left == null) {
                root = root.right;
            } else {
                // 先找出左子树的最右一个节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 把右子树接到左子树的最右节点
                pre.right = root.right;
                // 把左子树接到root上去完成一次迭代的拼接
                root.right = root.left;
                // 把左子树置为null
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
}
