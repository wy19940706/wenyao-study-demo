package com.wenyao.leetcode.Freq5;

import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import java.util.List;

/**
 * @Description: 验证二叉树
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
        for (int i = 0; i < list.size(); i++) {
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
}
