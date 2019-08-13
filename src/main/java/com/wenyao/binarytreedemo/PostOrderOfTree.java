package com.wenyao.binarytreedemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import java.util.List;
import java.util.Stack;

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
    }

    private static List<Integer> postOrderOfTree(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
            result.add(0, root.data);
        }
        return result;
    }

}
