package com.图;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/25 11:42
 */
class XYState {
    int x;
    int y;
    int effortFromStart;

    public XYState(int x, int y, int effortFromStart) {
        this.x = x;
        this.y = y;
        this.effortFromStart = effortFromStart;
    }
}

public class Demo_1631最小体力消耗路径 {
    public static void main(String[] args) {


        Demo_1631最小体力消耗路径 demo = new Demo_1631最小体力消耗路径();
        System.out.println(demo.minimumEffortPath(new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}}));
    }

    public List<int[]> getOrder(int x, int y, int[][] heights) {
        int[][] p = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        List<int[]> list = new ArrayList<>();
        for (int[] ints : p) {
            int newX = x + ints[0];
            int newY = y + ints[1];
            if (newX < 0 || newX >= heights.length || newY < 0 || newY >= heights[0].length) {
                continue;
            }
            list.add(new int[]{newX, newY, Math.abs(heights[newX][newY] - heights[x][y])});
        }
        return list;
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] toIndexLen = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(toIndexLen[i], Integer.MAX_VALUE);
        }
        Queue<XYState> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.effortFromStart));
        XYState xyState = new XYState(0, 0, 0);
        toIndexLen[0][0] = 0;
        queue.offer(xyState);
        while (!queue.isEmpty()) {
            XYState poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            if (x == n - 1 && y == m - 1) return poll.effortFromStart;
            if (poll.effortFromStart > toIndexLen[x][y]) {
                continue;
            }
            for (int[] ints : getOrder(x, y, heights)) {
                int newX = ints[0];
                int newY = ints[1];
                int len = Math.max(toIndexLen[x][y], ints[2]);
                if (toIndexLen[newX][newY] > len) {
                    toIndexLen[newX][newY] = len;
                    queue.offer(new XYState(newX, newY, len));
                }
            }
        }
        return -1;

    }
}
