package com.wenyao.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import cn.hutool.json.JSONUtil;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class LeetCode103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(JSONUtil.parse(result));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = Lists.newArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;
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
                if (!isReverse) {
                    curLevel.add(treeNode.data);
                } else {
                    curLevel.add(0, treeNode.data);
                }
            }
            isReverse = !isReverse;
            result.add(curLevel);
        }
        return result;
    }
}
