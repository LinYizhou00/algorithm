package com.岛屿问题;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/25 9:49
 */
public class Demo_1020飞地的数量 {
    public static void main(String[] args) {
        System.out.println(new Demo_1020飞地的数量().numEnclaves(
                new int[][]{{0, 0, 0, 0},
                        {1, 0, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}}
        ));
    }

    public int numEnclaves(int[][] grid) {
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
                if (grid[i][i1] == 1) {
                    count++;

                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int x, int y) {
        int[][] ints = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return;
        grid[x][y] = 0;
        for (int[] anInt : ints) {
            dfs(grid, x + anInt[0], y + anInt[1]);
        }
    }


}
