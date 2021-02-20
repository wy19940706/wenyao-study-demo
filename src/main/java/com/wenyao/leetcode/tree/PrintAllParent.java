package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @Description 打印所有父节点
 * @author wenyao
 * @Date 2021/1/27 上午10:31
 */
public class PrintAllParent {

    private static Boolean printParent(TreeNode root, int number) {
        if (root == null) {
            return false;
        }
        if (root.data == number) {
            return true;
        }
        if (printParent(root.left, number) || printParent(root.right, number)) {
            System.out.println(root.data + " ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        printParent(root, 7);
    }
}
