package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 找二叉搜索树的公共祖先
 */
public class LeetCode235 {

    public static void main(String[] args) {}

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果p或q有一个是root则最近公共祖先就是root
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode smallNode = p.data > q.data ? q : p;
        TreeNode bigNode = p.data > q.data ? p : q;
        if (bigNode.data < root.data) {
            return lowestCommonAncestor(root.left, smallNode, bigNode);
        } else if (smallNode.data > root.data) {
            return lowestCommonAncestor(root.right, smallNode, bigNode);
        } else {
            return root;
        }
    }
}
