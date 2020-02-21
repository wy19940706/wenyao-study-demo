package com.wenyao.leetcode.tree;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 层序遍历二叉树
 * @Author: wy
 * @CreateDate: 2019/3/26 22:47
 */
public class SwordToOffer37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = printTheTree(root);
        System.out.println(JSON.toJSONString(result));
    }

    private static List<Integer> printTheTree(TreeNode root) {
        if (root == null) {
            return Lists.newArrayList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = Lists.newArrayList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                result.add(node.data);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return result;
    }
}
