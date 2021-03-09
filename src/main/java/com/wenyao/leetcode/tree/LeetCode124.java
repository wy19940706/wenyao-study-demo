package com.wenyao.leetcode.tree;

import com.wenyao.leetcode.TreeNode;

/**
 * @author wenyao
 * @Description 二叉树中的最大路径和
 * @Date 2021/3/2 下午11:58
 */
public class LeetCode124 {

    class Solution {
        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            func(root);
            return res;
        }

        public int func(TreeNode root) {// 后序遍历
            if (root == null) {
                return 0;
            }
            int leftValue = Math.max(func(root.left), 0);// 存左边最大值，负数就取0
            int rightValue = Math.max(func(root.right), 0);// 存右边最大值，负数就取0
            int sum = root.data + leftValue + rightValue;// 该节点最大路径和
            res = Math.max(res, sum);// 不断更新最大值
            return root.data + Math.max(leftValue, rightValue);// 返回当前节点值和当前节点连接的最大值，比如root在20时，返回 //20和15
        }
    }

}
