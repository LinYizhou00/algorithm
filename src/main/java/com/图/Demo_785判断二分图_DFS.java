package com.图;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 19:32
 */
public class Demo_785判断二分图_DFS {
    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1,2, 3}, {0, 2}, {1,0, 3}, {0, 2}}));
    }

    static boolean[] colors;
    static boolean ok = true;
    static boolean[] visited;

    public static boolean isBipartite(int[][] graph) {
        colors = new boolean[graph.length];
        visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return ok;

    }

    public static void traverse(int[][] graph, int index) {

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
