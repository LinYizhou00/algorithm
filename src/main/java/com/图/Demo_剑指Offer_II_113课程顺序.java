package com.图;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 19:15
 */
public class Demo_剑指Offer_II_113课程顺序 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

    boolean hsaCycle = false;
    boolean[] visited;
    boolean[] path;
    LinkedList<Integer> res;

    public void traverse(int index, List<Integer>[] graph) {
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


    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new LinkedList[numCourses];
        for (int i = 0; i < list.length; i++) list[i] = new LinkedList<>();
        for (int[] n : prerequisites) list[n[1]].add(n[0]);
        return list;
    }

}
