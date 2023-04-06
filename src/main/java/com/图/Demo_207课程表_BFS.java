package com.图;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 12:57
 */
public class Demo_207课程表_BFS {
    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ru = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        return traverse(numCourses, graph);
    }

    static int[] ru;
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < graph.length; i++) graph[i] = new LinkedList<>();
        for (int[] prerequisite : prerequisites) {
            ru[prerequisite[0]]++;
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        for (int i = 0; i < ru.length; i++)
            if (ru[i] == 0) queue.offer(i);

        return graph;

    }

    public static boolean traverse(int all, List<Integer>[] graph) {
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            List<Integer> list = graph[poll];
            for (int i = 0; i < list.size(); i++) {
                ru[list.get(i)]--;
                if (ru[list.get(i)] == 0) queue.offer(list.get(i));
            }
        }
        return count == all;
    }
}
