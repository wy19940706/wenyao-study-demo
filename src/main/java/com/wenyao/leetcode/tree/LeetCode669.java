package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 修剪二叉搜索树
 * @Date 2021/3/9 上午12:14
 */
public class LeetCode669 {

    // 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
    // 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
    // 修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
    // 输入：root = [1,0,2], low = 1, high = 2
    // 输出：[1,null,2]
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 如果当前结点小于下界，直接将修剪后的右子树替换当前节点并返回
        if (root.data < low) {
            return trimBST(root.right, low, high);
        }
        // 如果当前结点大于上界，直接将修剪后的左子树替换当前节点并返回
        if (root.data > high) {
            return trimBST(root.left, low, high);
        }
        // 如果当前结点不越界，继续往两边扩散寻找第一个越界的结点
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

}
