package com.wenyao.binarytreedemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * @Description: 二叉树的先序遍历(leetcode 144)
 * @Author: wy
 * @CreateDate: 2019/3/28 22:37
 */
public class PreOrderOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(JSON.toJSONString(preOrderOfTree(root)));
    }

    private static List<Integer> preOrderOfTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = Lists.newArrayList();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.data);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }

}
