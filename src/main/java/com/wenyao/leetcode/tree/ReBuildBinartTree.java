package com.wenyao.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.wenyao.leetcode.TreeNode;

/**
 * @Description: 前序中序遍历重建二叉树
 * @Author: wy
 * @CreateDate: 2019/3/28 23:25
 */
public class ReBuildBinartTree {

    private static Map<Integer, Integer> indexForInOrders = Maps.newHashMap();

    public static void main(String[] args) {
        int[] preOrder = new int[] {3, 9, 20, 15, 7};
        int[] inOrder = new int[] {9, 3, 15, 20, 7};
        System.out.println(JSON.toJSONString(reBuildBinaryTree(preOrder, inOrder)));
    }

    private static TreeNode reBuildBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reBuildBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode reBuildBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndexOfRoot = indexForInOrders.get(root.data);
        int leftTreeSize = inIndexOfRoot - inL;
        root.left = reBuildBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reBuildBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    public class Solution {

        // 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做

        private Map<Integer, Integer> reverses;
        private int[] preorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int preLen = preorder.length;
            int inLen = inorder.length;

            // 可以不做判断，因为题目中给出的数据都是有效的
            if (preLen != inLen) {
                return null;
            }

            this.preorder = preorder;

            // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
            reverses = new HashMap<>(inLen);
            for (int i = 0; i < inLen; i++) {
                reverses.put(inorder[i], i);
            }

            return buildTree(0, preLen - 1, 0, inLen - 1);
        }

        /**
         * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
         *
         * @param preL 前序遍历数组的区间左端点
         * @param preR 前序遍历数组的区间右端点
         * @param inL 中序遍历数组的区间左端点
         * @param inR 中序遍历数组的区间右端点
         * @return 构建的新二叉树的根结点
         */
        private TreeNode buildTree(int preL, int preR, int inL, int inR) {
            if (preL > preR || inL > inR) {
                return null;
            }
            // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
            int rootData = preorder[preL];
            TreeNode root = new TreeNode(rootData);

            int rootIndex = reverses.get(rootData);

            // 这一步得画草稿，计算边界的取值，必要时需要解方程，并不难
            root.left = buildTree(preL + 1, preL + (rootIndex - inL), inL, rootIndex - 1);
            root.right = buildTree(preL + (rootIndex - inL) + 1, preR, rootIndex + 1, inR);
            return root;
        }
    }

    public class Wenyao {
        public Map<Integer, Integer> inOrderToIndex = Maps.newHashMap();
        public int[] preOrder;

        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            int preOrderLen = preOrder.length;
            int inOrderLen = inOrder.length;
            this.preOrder = preOrder;

            for (int i = 0; i < inOrderLen; i++) {
                inOrderToIndex.put(inOrder[i], i);
            }
            return buildTree(0, preOrderLen - 1, 0, inOrderLen - 1);
        }

        private TreeNode buildTree(int preL, int preR, int inL, int inR) {
            if (preL > preR || inL > inR) {
                return null;
            }
            int rootData = preOrder[preL];
            TreeNode root = new TreeNode(rootData);
            int rootIndex = inOrderToIndex.get(rootData);
            root.left = buildTree(preL + 1, rootIndex - inL + preL, inL, rootIndex - 1);
            root.right = buildTree(rootIndex - inL + preL + 1, preR, rootIndex + 1, inR);
            return root;
        }

    }

}
