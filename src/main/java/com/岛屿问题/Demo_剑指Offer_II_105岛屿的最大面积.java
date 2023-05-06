package com.岛屿问题;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/25 10:16
 */
public class Demo_剑指Offer_II_105岛屿的最大面积 {
    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    swapRes = 0;
                    dfs(grid, i, j);
                    res = Math.max(swapRes, res);
                    swapRes = 0;
                }
            }
        }
        return res;
    }

    int swapRes;

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return;
        int[][] ints = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        swapRes++;
        grid[x][y] = 0;
        for (int[] anInt : ints) {
            dfs(grid, x + anInt[0], y + anInt[1]);
        }
    }
}
