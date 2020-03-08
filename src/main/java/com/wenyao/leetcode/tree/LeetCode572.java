package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * 另一棵树的子树-字节跳动
 */
public class LeetCode572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        if (s.data != t.data) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        } else {
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

}
