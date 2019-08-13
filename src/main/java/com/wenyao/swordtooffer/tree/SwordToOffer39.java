package com.wenyao.swordtooffer.tree;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import java.util.List;

/**
 * @Description: 二叉树中和为某一值的路径
 * @Author: wy
 * @CreateDate: 2019/3/26 22:58
 */
public class SwordToOffer39 {

    private static List<List<Integer>> result = Lists.newArrayList();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode leftNode1 = new TreeNode(5);
        TreeNode rightNode1 = new TreeNode(12);
        root.left = leftNode1;
        root.right = rightNode1;
        TreeNode leftNode2 = new TreeNode(4);
        TreeNode rightNode2 = new TreeNode(7);
        leftNode1.left = leftNode2;
        leftNode1.right = rightNode2;
        System.out.println(JSON.toJSONString(findPath(root, 22)));
    }

    private static List<List<Integer>> findPath(TreeNode root, int target) {
        dfs(root, target, Lists.newArrayList());
        return result;
    }

    private static void dfs(TreeNode root, int target, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        target -= root.data;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(Lists.newArrayList(path));
        } else {
            dfs(root.left, target, path);
            dfs(root.right, target, path);
        }
        path.remove(path.size() - 1);
    }

}
