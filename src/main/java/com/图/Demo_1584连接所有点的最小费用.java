package com.图;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/24 19:59
 */
public class Demo_1584连接所有点的最小费用 {
    public static void main(String[] args) {
        Demo_1584连接所有点的最小费用 demo = new Demo_1584连接所有点的最小费用();
        System.out.println(demo.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 10}}));
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{
                        i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
                });
            }
        }
        NewUF uf = new NewUF(points.length);
        edges.sort(Comparator.comparingInt(o -> o[2]));
        int len = 0;
        for (int[] edge : edges) {
            if (!uf.isConnect(edge[0], edge[1])) {
                len += edge[2];
                uf.union(edge[0], edge[1]);
            }
        }
        return len;
    }
}
