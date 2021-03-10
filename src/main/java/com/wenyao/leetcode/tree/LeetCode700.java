package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 二叉搜索树中的搜索
 * @Date 2021/3/9 下午11:50
 */
public class LeetCode700 {

    // 递归
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.data) {
            return root;
        }
        return root.data > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    // 迭代
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && val != root.data) {
            root = root.data > val ? root.left : root.right;
        }
        return root;
    }
}
