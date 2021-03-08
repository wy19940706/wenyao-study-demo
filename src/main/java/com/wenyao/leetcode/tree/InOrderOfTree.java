package com.wenyao.leetcode.tree;

import java.util.List;
import java.util.Stack;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 二叉树中序遍历（leetcode 94）
 * @Author: wy
 * @CreateDate: 2019/3/28 22:44
 */
public class InOrderOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(JSON.toJSONString(inOrderOfTree(root)));
        System.out.println(JSON.toJSONString(inorderTraversal(root)));
    }

    // 中序遍历使用栈
    private static List<Integer> inOrderOfTree(TreeNode root) {
        List<Integer> result = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.data);
                cur = cur.right;
            }
        }
        return result;
    }


    // 递归中序遍历
    public static List<Integer> item = Lists.newArrayList();

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return item;
        }
        inorderTraversal(root.left);
        item.add(root.data);
        inorderTraversal(root.right);
        return item;
    }

}
