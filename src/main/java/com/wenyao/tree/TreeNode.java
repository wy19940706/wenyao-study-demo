package com.wenyao.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

import cn.hutool.core.collection.CollectionUtil;

public interface TreeNode<T, N extends TreeNode<T, N>> {
    T getParentId();

    T getId();

    List<N> getChildren();

    void setChildren(List<N> children);

    /**
     * 构造树形结构
     * 
     * @param treeNodes
     * @return
     */
    static <T, N extends TreeNode<T, N>> List<N> makeTree(List<N> treeNodes, T rootNodeId) {
        if (CollectionUtil.isEmpty(treeNodes)) {
            return treeNodes;
        }

        Map<T, List<N>> parentIdMapping = treeNodes.stream().collect(Collectors.groupingBy(TreeNode::getParentId));
        List<N> rootNodes = parentIdMapping.get(rootNodeId);
        Queue<N> processQueue = new ArrayDeque<>(rootNodes);
        while (!processQueue.isEmpty()) {
            N treeNode = processQueue.poll();
            List<N> children = parentIdMapping.get(treeNode.getId());
            if (children != null) {
                treeNode.setChildren(children);
                for (N child : children) {
                    processQueue.offer(child);
                }
            }
        }
        return rootNodes;
    }

    /**
     * 构造树形结构
     * 
     * @param treeNodes
     * @param rootNodeId
     * @param level 要构造的树层级，大于0
     * @param <T>
     * @param <N>
     * @return
     */
    static <T, N extends TreeNode<T, N>> List<N> makeTree(List<N> treeNodes, T rootNodeId, Integer level) {
        Assert.isTrue(level > 0, "illegal level");
        if (CollectionUtil.isEmpty(treeNodes)) {
            return treeNodes;
        }

        Map<T, List<N>> parentIdMapping = treeNodes.stream().collect(Collectors.groupingBy(TreeNode::getParentId));
        List<N> rootNodes = parentIdMapping.get(rootNodeId);

        Queue<N> nextProcessQueue = new ArrayDeque<>(rootNodes);

        while (--level > 0) {
            Queue<N> processQueue = new ArrayDeque<>(nextProcessQueue);
            nextProcessQueue.clear();
            while (!processQueue.isEmpty()) {
                N treeNode = processQueue.poll();
                List<N> children = parentIdMapping.get(treeNode.getId());
                if (children != null) {
                    treeNode.setChildren(children);
                    for (N child : children) {
                        nextProcessQueue.offer(child);
                    }
                }
            }
        }

        return rootNodes;
    }

    /**
     * 树打散到数组中
     * 
     * @param rootNodes 树形结构的数据
     * @return
     */
    static <T, N extends TreeNode<T, N>> List<N> flatten(List<N> rootNodes) {
        if (CollectionUtil.isEmpty(rootNodes)) {
            return rootNodes;
        }
        Queue<N> processQueue = new ArrayDeque<>(rootNodes);
        List<N> nodes = new ArrayList<>();
        while (!processQueue.isEmpty()) {
            N treeNode = processQueue.poll();
            nodes.add(treeNode);
            if (treeNode.getChildren() != null) {
                treeNode.getChildren().forEach(processQueue::offer);
            }
        }
        return nodes;
    }

    /**
     * 获取树的叶子节点
     * 
     * @param rootNodes 树形结构的数据
     * @return
     */
    static <T, N extends TreeNode<T, N>> List<N> getLeafs(List<N> rootNodes) {
        List<N> leafs = new ArrayList<>();
        Queue<N> processQueue = new ArrayDeque<>(rootNodes);
        while (!processQueue.isEmpty()) {
            N treeNode = processQueue.poll();
            if (treeNode.getChildren() != null) {
                treeNode.getChildren().forEach(processQueue::offer);
            } else {
                leafs.add(treeNode);
            }
        }
        return leafs;
    }

    /**
     * 移除叶子节点
     * 
     * @param rootNodes
     * @param <T>
     * @param <N>
     */
    static <T, N extends TreeNode<T, N>> void removeLeafs(List<N> rootNodes) {
        if (CollectionUtil.isEmpty(rootNodes)) {
            return;
        }
        rootNodes.forEach(rootNode -> {
            rootNode.getChildren().removeIf(childNode -> CollectionUtil.isEmpty(childNode.getChildren()));
            removeLeafs(rootNode.getChildren());
        });
    }

    /**
     * 复制一棵树
     * 
     * @param rootNodes 树形结构的数据
     * @param mapper 树节点转换
     * @return 转换后树节点类型的树
     */
    static <MID, NID, M extends TreeNode<MID, M>, N extends TreeNode<NID, N>> List<N> copy(List<M> rootNodes,
            Function<? super M, ? extends N> mapper) {
        List<N> nRootNodes = new ArrayList<>();
        for (M m : rootNodes) {
            N newNode = mapper.apply(m);
            if (m.getChildren() != null) {
                newNode.setChildren(copy(m.getChildren(), mapper));
            }
            nRootNodes.add(newNode);
        }
        return nRootNodes;
    }

    /**
     * 根据节点ID获取祖先节点，包含自身对应的节点
     * 
     * @param treeNodes
     * @param leafNodeIds
     * @param <T>
     * @param <N>
     * @return
     */
    static <T, N extends TreeNode<T, N>> List<N> getAncestors(List<N> treeNodes, List<T> leafNodeIds) {
        if (treeNodes == null || treeNodes.isEmpty() || leafNodeIds == null || leafNodeIds.isEmpty()) {
            return new ArrayList<>();
        }

        Map<T, T> parentIdMapping =
                treeNodes.stream().collect(Collectors.toMap(TreeNode::getId, TreeNode::getParentId));
        Map<T, N> idMapping = treeNodes.stream().collect(Collectors.toMap(TreeNode::getId, Function.identity()));

        List<N> nodes = new ArrayList<>();
        Queue<T> processQueue = new ArrayDeque<>(leafNodeIds);

        Set<T> ids = new HashSet<>();
        Set<T> parentIds = new HashSet<>();

        while (!processQueue.isEmpty()) {
            T id = processQueue.poll();
            N node = idMapping.get(id);
            if (node != null) {
                if (ids.add(id)) {
                    nodes.add(node);
                }
                T parentId = parentIdMapping.get(id);
                if (parentIds.add(parentId)) {
                    processQueue.offer(parentId);
                }
            }
        }

        return nodes;
    }
}
