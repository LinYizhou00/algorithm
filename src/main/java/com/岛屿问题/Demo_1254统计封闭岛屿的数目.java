package com.岛屿问题;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/25 9:19
 */
public class Demo_1254统计封闭岛屿的数目 {
    public static void main(String[] args) {
        System.out.println(new Demo_1254统计封闭岛屿的数目().closedIsland(
                new int[][]{{1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}}
        ));
    }

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, 0, i);
            dfs(grid, grid.length - 1, i);
        }
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length - 1);
        }
        int count = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int i1 = 1; i1 < grid[0].length; i1++) {
                if (grid[i][i1] == 0) {
                    count++;
                    dfs(grid, i, i1);
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int x, int y) {
        int[][] ints = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) return;
        grid[x][y] = 1;
        for (int[] anInt : ints) {
            dfs(grid, x + anInt[0], y + anInt[1]);
        }
    }
}
