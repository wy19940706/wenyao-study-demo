package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3 解释: 节点 5
 * 和节点 1 的最近公共祖先是节点 3。
 */
public class LeetCode236 {

    public static void main(String[] args) {}

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果p或q有一个是root则最近公共祖先就是root
        if (root == null || p == root || q == root) {
            return root;
        }
        // 去左子树找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 去右子树找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右子树都找到一个，则root是最近祖先
        if (left != null && right != null) {
            return root;
        }
        // 否则左子树有则返回左子树，右子树有则返回右子树
        return left == null ? right : left;
    }
}
