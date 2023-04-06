package com.图;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/21 9:55
 */
public class Demo_210课程表II_BFS {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}})));

    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ru = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        if (traverse(numCourses, graph)) {
            int[] ints = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ints[i] = res.get(i);
            }
            return ints;
        } else {
            return new int[0];
        }
    }

    static int[] ru;
    static Queue<Integer> queue = new LinkedList<Integer>();
    static List<Integer> res = new ArrayList<Integer>();

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
            res.add(poll);
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
