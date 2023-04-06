package com.图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 21:37
 */
public class Demo_剑指Offer_II_110所有路径 {
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(graph, 0, res);
        return res;

    }

    private void traverse(int[][] graph, int i, List<List<Integer>> res) {
        path.add(i);
        if (graph.length - 1 == i) {
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for (int r : graph[i]) {
            traverse(graph, r, res);
        }
        path.removeLast();
    }
}
