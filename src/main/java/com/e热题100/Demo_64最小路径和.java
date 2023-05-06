package com.e热题100;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/2 23:32
 */
public class Demo_64最小路径和 {
    public static void main(String[] args) {
        System.out.println(new Demo_64最小路径和().minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }

    int[] memo;

    public int minPathSum(int[][] grid) {
        memo = new int[grid.length * grid[0].length];
        Arrays.fill(memo, -1);
        return dp(grid, grid.length - 1, grid[0].length - 1);

    }

    public int dp(int[][] grid, int x, int y) {

        if (x == 0 && y == 0) return grid[0][0];
        if (x < 0 || y < 0) return 300;
        int i = x * grid[0].length + y;
        if (memo[i] != -1) return memo[i];
        int left = dp(grid, x, y - 1) + grid[x][y];
        int up = dp(grid, x - 1, y) + grid[x][y];
        int min = Math.min(left, up);
        memo[i] = min;
        return min;
    }
}
