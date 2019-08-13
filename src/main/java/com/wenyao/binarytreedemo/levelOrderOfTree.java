package com.wenyao.binarytreedemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 二叉树层次遍历(每一层一个list中)
 * @Author: wy
 * @CreateDate: 2019/3/28 23:03
 */
public class levelOrderOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(JSON.toJSONString(levelOrderOfTree(root)));
    }

    private static List<List<Integer>> levelOrderOfTree(TreeNode root) {
        List<List<Integer>> result = Lists.newArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = Lists.newArrayList();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.data);
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
