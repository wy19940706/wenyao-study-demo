package com.wenyao.leetcode.tree;

import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

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
        System.out.println(JSON.toJSONString(preOrderTraversal(root)));
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
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            list.add(root.data);
        }
        return list;
    }

    public static List<Integer> item = Lists.newArrayList();

    public static List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return item;
        }
        item.add(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        return item;
    }

}
