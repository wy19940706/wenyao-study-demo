package com.wenyao.leetcode.list;

import com.alibaba.fastjson.JSON;
import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 二叉树转双向链表
 * @Author: wy
 * @CreateDate: 2019/4/2 15:49
 */
public class SwordToOffer41 {

    private static TreeNode pre = null;
    private static TreeNode head = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode result = convertToList(root);
        System.out.println(JSON.toJSONString(result));
    }

    private static TreeNode convertToList(TreeNode root) {
        inOrder(root);
        return head;
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        if (head == null) {
            head = root;
        }
        inOrder(root.right);
    }
}
