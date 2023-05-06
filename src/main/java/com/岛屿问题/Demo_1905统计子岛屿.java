package com.岛屿问题;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/25 10:04
 */
public class Demo_1905统计子岛屿 {
    public static void main(String[] args) {


        System.out.println(new Demo_1905统计子岛屿().countSubIslands(
                new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}},
                new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}
        ));

    }

    boolean isSwap;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    isSwap = true;
                    dfs(grid1, grid2, i, j);
                    if (isSwap) count++;
                }
            }
        }
        return count;


    }

    public void dfs(int[][] grid1, int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return;
        int[][] ints = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (grid1[x][y] != grid[x][y]) isSwap = false;
        grid[x][y] = 0;
        for (int[] anInt : ints) {
            dfs(grid1, grid, x + anInt[0], y + anInt[1]);
        }
    }
}
