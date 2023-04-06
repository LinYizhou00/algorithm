package com.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 21:46
 */
public class Demo_207课程表_DFS {
    public static void main(String[] args) {

        System.out.println(canFinish(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(i, graph);
        }
        return !hasCycle;
    }

    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        return graph;

    }

    static boolean[] visited;
    static boolean[] path;
    static boolean hasCycle = false;


    public static void traverse(int index, List<Integer>[] graph) {
        if (path[index]) {
            hasCycle = true;
        }
        if (visited[index] || hasCycle) return;
        path[index] = true;
        visited[index] = true;
        for (int i : graph[index]) {
            traverse(i, graph);
        }
        path[index] = false;
    }
}
