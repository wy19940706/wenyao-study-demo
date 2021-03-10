package com.wenyao.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.Lists;

/**
 * @Description: 层序遍历输出二叉树每一层的节点
 * @Author: wy
 * @CreateDate: 2019/3/5 17:24
 */
public class LeetCode102 {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode leftNode = new TreeNode(4);
        TreeNode rightNode = new TreeNode(5);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        System.out.println(printTree(treeNode));
        System.out.println(printTheTree(treeNode));
    }

    private static List<List<Integer>> printTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> oneFloor = new ArrayList<>();
        oneFloor.add(root.value);
        result.add(oneFloor);
        List<List<Integer>> left = printTree(root.left);
        List<List<Integer>> right = printTree(root.right);
        for (int i = 0; i < left.size() || i < right.size(); i++) {
            List<Integer> item = new ArrayList<>();
            if (left.size() > 0) {
                for (Integer value : left.get(i)) {
                    item.add(value);
                }
            }
            if (right.size() > 0) {
                for (Integer value : right.get(i)) {
                    item.add(value);
                }
            }
            result.add(item);
        }
        return result;
    }

    private static List<List<Integer>> printTheTree(TreeNode root) {
        if (root == null) {
            return Lists.newArrayList();
        }
        List<List<Integer>> result = Lists.newArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = Lists.newArrayList();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.value);
                count--;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
