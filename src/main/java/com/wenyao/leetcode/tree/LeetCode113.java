package com.wenyao.leetcode.tree;

import java.util.List;

import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class LeetCode113 {

    List<List<Integer>> result = Lists.newArrayList();
    List<Integer> item = Lists.newArrayList();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        sum -= root.data;
        item.add(root.data);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(Lists.newArrayList(item));
            }
        }
        if (root.left != null) {
            pathSum(root.left, sum);
        }
        if (root.right != null) {
            pathSum(root.right, sum);
        }
        item.remove(item.size() - 1);
        return result;
    }
}
