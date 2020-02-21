package com.wenyao.leetcode.tree;

import java.util.Map;

import com.google.common.collect.Maps;
import com.wenyao.leetcode.TreeNode;

/**
 * 根据中序遍历和后序遍历重建二叉树
 */
public class LeetCode106 {

    public Map<Integer, Integer> inOrderToIndex = Maps.newHashMap();
    public int[] postOrder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int postOrderLen = postorder.length;
        int inOrderLen = inorder.length;
        this.postOrder = postorder;

        for (int i = 0; i < inOrderLen; i++) {
            inOrderToIndex.put(inorder[i], i);
        }
        return buildTree(0, postOrderLen - 1, 0, inOrderLen - 1);
    }

    private TreeNode buildTree(int postL, int postR, int inL, int inR) {
        if (postL > postR || inL > inR) {
            return null;
        }
        int rootData = postOrder[postR];
        TreeNode root = new TreeNode(rootData);
        int rootIndex = inOrderToIndex.get(rootData);
        root.left = buildTree(postL, rootIndex - inR + postR - 1, inL, rootIndex - 1);
        root.right = buildTree(rootIndex - inR + postR, postR - 1, rootIndex + 1, inR);
        return root;
    }
}
