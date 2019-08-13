package com.wenyao.binarytreedemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.wenyao.leetcode.TreeNode;

import java.util.Map;

/**
 * @Description: 重建二叉树
 * @Author: wy
 * @CreateDate: 2019/3/28 23:25
 */
public class ReBuildBinartTree {

    private static Map<Integer, Integer> indexForInOrders = Maps.newHashMap();

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
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

}
