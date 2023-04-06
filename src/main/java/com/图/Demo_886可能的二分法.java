package com.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 22:08
 */
public class Demo_886可能的二分法 {
    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }

    static boolean[] colors;
    static boolean[] visited;
    static boolean ok = true;

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new boolean[n];
        visited = new boolean[n];
        List<Integer>[] lists = changeMsg(n, dislikes);
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                traverse(i, lists);
        }
        return ok;
    }

    public static void traverse(int index, List<Integer>[] graph) {
        if (!ok) return;
        visited[index] = true;
        for (int i = 0; i < graph[index].size(); i++) {
            if (visited[graph[index].get(i)]) {
                if (colors[graph[index].get(i)] == colors[index]) {
                    ok = false;
                    return;
                }
            } else {
                colors[graph[index].get(i)] = !colors[index];

                //visited[graph[index].get(i)] = true;
                traverse(graph[index].get(i), graph);
            }
        }
    }


    public static List<Integer>[] changeMsg(int n, int[][] dislikes) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<Integer>();
        }
        for (int[] dislike : dislikes) {
            //双向
            lists[dislike[0] - 1].add(dislike[1] - 1);
            lists[dislike[1] - 1].add(dislike[0] - 1);
        }
        return lists;
    }
}
