package com.图;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 9:55
 */
public class Demo_210课程表II_DFS {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{})));
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        res = new LinkedList<>();
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(i, graph);
        }
        if (hsaCycle) {
            return new int[]{};
        } else {

            int size = res.size();
            int[] ints = new int[size];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = res.get(size - i - 1);
            }
            return ints;

        }

    }

    static boolean hsaCycle = false;
    static boolean[] visited;
    static boolean[] path;
    static LinkedList<Integer> res;

    public static void traverse(int index, List<Integer>[] graph) {
        if (path[index]) {
            hsaCycle = true;
            return;
        }
        if (hsaCycle || visited[index]) return;
        path[index] = true;
        visited[index] = true;
        List<Integer> list = graph[index];
        for (int i = 0; i < list.size(); i++) traverse(list.get(i), graph);
        path[index] = false;
        res.add(index);
    }


    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new LinkedList[numCourses];
        for (int i = 0; i < list.length; i++) list[i] = new LinkedList<>();
        for (int[] n : prerequisites) list[n[1]].add(n[0]);
        return list;
    }

}
