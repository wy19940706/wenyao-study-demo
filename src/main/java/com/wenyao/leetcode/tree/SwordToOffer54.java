package com.wenyao.leetcode.tree;

import java.util.Stack;

import com.wenyao.leetcode.TreeNode;

/**
 * 二叉搜索树的第k大节点
 */
public class SwordToOffer54 {

    public int kthLargest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            TreeNode pop = stack.pop();
            if (count == k) {
                return pop.data;
            }
            count++;
            root = pop.left;
        }
        return 0;
    }
}
