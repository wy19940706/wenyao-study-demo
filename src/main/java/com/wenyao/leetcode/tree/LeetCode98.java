package com.wenyao.leetcode.tree;

import java.util.List;

import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 验证二叉搜索树
 * @Author: wy
 * @CreateDate: 2019/3/12 22:34
 */
public class LeetCode98 {
    public static void main(String[] args) {

    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> list = Lists.newArrayList();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).data >= list.get(i + 1).data) {
                return false;
            }
        }
        return true;
    }

    private static void inOrder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root);
            inOrder(root.right, list);
        }
    }

    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> result = Lists.newArrayList();
        inOrder(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i).data >= result.get(i + 1).data) {
                return false;
            }
        }
        return true;
    }
}