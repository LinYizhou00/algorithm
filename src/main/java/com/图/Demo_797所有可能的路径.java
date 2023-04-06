package com.图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 20:37
 */
public class Demo_797所有可能的路径 {
    public static void main(String[] args) {

    }

    static LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(graph, 0, res);
        return res;

    }

    public void traverse(int[][] graph, int index, List<List<Integer>> res) {
        path.add(index);
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int i : graph[index])  traverse(graph, i, res);
        path.removeLast();

    }
}
