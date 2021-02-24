package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.ListNode;
import com.wenyao.leetcode.TreeNode;

/**
 * 二叉树中的列表
 */
public class LeetCode1367 {

    // 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
    // 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False
    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.data == head.value) {
            boolean isSub = matchSubPath(head.next, root.left) || matchSubPath(head.next, root.right);
            if (isSub) {
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean matchSubPath(ListNode head, TreeNode node) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (head.value != node.data) {
            return false;
        }
        return matchSubPath(head.next, node.left) || matchSubPath(head.next, node.right);
    }
}
