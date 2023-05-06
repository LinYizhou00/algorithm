package com.岛屿问题;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/25 9:07
 */
public class Demo_200岛屿数量 {
    char[][] swap;

    public int numIslands(char[][] grid) {
        swap = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= swap.length || y >= swap[0].length || swap[x][y] == '0') return;
        int[][] ints = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        swap[x][y] = '0';
        for (int[] anInt : ints) {
            dfs(x + anInt[0], y + anInt[1]);
        }
    }

}
