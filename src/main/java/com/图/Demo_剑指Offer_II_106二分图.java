package com.图;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 23:31
 */
public class Demo_剑指Offer_II_106二分图 {
    boolean[] colors;
    boolean ok = true;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        colors = new boolean[graph.length];
        visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return ok;

    }

    public void traverse(int[][] graph, int index) {

        if (!ok) return;
        visited[index] = true;
        for (int i = 0; i < graph[index].length; i++) {
            if (visited[graph[index][i]]) {
                if (colors[index] == colors[graph[index][i]]) {
                    ok = false;
                    return;
                }
            } else {
                colors[graph[index][i]] = !colors[index];
                traverse(graph, graph[index][i]);
            }
        }

    }
}
