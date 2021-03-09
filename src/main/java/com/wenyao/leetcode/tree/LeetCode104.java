package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 二叉树的最大深度
 * @Date 2021/3/1 下午11:15
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
