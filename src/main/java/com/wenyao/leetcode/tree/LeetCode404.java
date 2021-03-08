package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 左叶子之和
 * @Date 2021/3/9 上午12:03
 */
public class LeetCode404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    private int dfs(TreeNode root) {
        int result = 0;
        if (root.left != null) {
            result += isLeafNode(root.left) ? root.left.data : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            result += dfs(root.right);
        }
        return result;
    }

    private boolean isLeafNode(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }
}
