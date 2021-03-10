package com.wenyao.leetcode.tree;

import java.util.Queue;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 最小高度
 * @Date 2021/2/24 下午7:53
 */
public class TheMinHeightOfTree {

    public static void main(String[] args) {

    }

    private static int getMinLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = Lists.newLinkedList();
        Set<TreeNode> visited = Sets.newHashSet();
        queue.offer(root);
        visited.add(root);
        int step = 0;
        while (!queue.isEmpty()) {

            step++;
        }
        return 0;
    }
}
