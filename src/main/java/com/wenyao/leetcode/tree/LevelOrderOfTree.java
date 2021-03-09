package com.wenyao.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 二叉树层次遍历(每一层一个list中)
 * @Author: wy
 * @CreateDate: 2019/3/28 23:03
 */
public class LevelOrderOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(JSON.toJSONString(levelOrderOfTree(root)));
    }

    // 迭代做法 用队列
    // 时间复杂度：O(N)，因为每个节点恰好会被运算一次。
    // 空间复杂度：O(N)，保存输出结果的数组包含 N 个节点的值。
    public static List<List<Integer>> levelOrderOfTree(TreeNode root) {
        List<List<Integer>> result = Lists.newArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = Lists.newArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                curLevel.add(treeNode.data);
            }
            result.add(curLevel);
        }
        return result;
    }

    // 递归做法
    // 时间复杂度：O(N)，因为每个节点恰好会被运算一次。
    // 空间复杂度：O(N)，保存输出结果的数组包含 N 个节点的值。
    public static List<List<Integer>> result = Lists.newArrayList();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    private static void helper(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(Lists.newArrayList());
        }
        result.get(level).add(root.data);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

}
