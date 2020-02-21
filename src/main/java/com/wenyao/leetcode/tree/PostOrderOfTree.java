package com.wenyao.leetcode.tree;

import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 二叉树的后序遍历
 * @Author: wy
 * @CreateDate: 2019/3/28 22:56
 */
public class PostOrderOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(JSON.toJSONString(postOrderOfTree(root)));
        System.out.println(JSON.toJSONString(postOrderTraversal(root)));
    }

    private static List<Integer> postOrderOfTree(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            result.add(0, node.data);
        }
        return result;
    }

    public static List<Integer> item = Lists.newArrayList();

    public static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return item;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        item.add(root.data);
        return item;
    }

}
