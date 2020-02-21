package com.wenyao.leetcode.tree;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 以图判树（给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。）
 */
public class LeetCode261 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(5, edges));
    }

    private static boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = Maps.newHashMap();
        buildGraph(graph, n, edges);
        Queue<Integer> queue = Lists.newLinkedList();
        Set<Integer> visited = Sets.newHashSet();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (!visited.add(cur)) {
                return false;
            }
            for (int nei : graph.get(cur)) {
                queue.offer(nei);
                graph.get(nei).remove(cur);
            }
        }
        return visited.size() == n;
    }

    private static void buildGraph(Map<Integer, Set<Integer>> graph, int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.put(i, Sets.newHashSet());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}
