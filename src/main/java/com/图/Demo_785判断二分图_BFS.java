package com.图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 19:32
 */
public class Demo_785判断二分图_BFS {
    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
    }

    static boolean[] visited;
    static boolean[] colors;
    static boolean ok = true;
    static Queue<Integer> queue = new LinkedList<>();

    public static boolean isBipartite(int[][] graph) {
        visited = new boolean[graph.length];
        colors = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) bfs(graph, i);
        }
        return ok;
    }

    public static void bfs(int[][] graph, int index) {
        queue.offer(index);
        visited[index] = true;
        while (!queue.isEmpty() && ok) {
            Integer poll = queue.poll();
            for (int anInt : graph[poll]) {
                if (visited[anInt]) {
                    if (colors[anInt] == colors[poll]) {
                        ok = false;
                        return;
                    }
                } else {
                    colors[anInt] = !colors[poll];
                    visited[anInt] = true;
                    queue.offer(anInt);
                }
            }
        }
    }
}
