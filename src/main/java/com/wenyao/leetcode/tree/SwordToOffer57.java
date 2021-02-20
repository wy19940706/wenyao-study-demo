package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 二叉树的下一个节点
 */
public class SwordToOffer57 {

    public static TreeNode getNextNode(TreeNode node) {
        if (node.right != null) {
            while (node != null) {
                if (node.left != null) {
                    node = node.left;
                }
                if (node.right != null) {
                    node = node.right;
                }
            }
            return node;
        }
        if (node.right == null) {

        }
        return node;
    }

}
