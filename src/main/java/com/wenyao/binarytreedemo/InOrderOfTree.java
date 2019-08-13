package com.wenyao.binarytreedemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.wenyao.leetcode.TreeNode;

import java.util.List;
import java.util.Stack;

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
    }

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

}
