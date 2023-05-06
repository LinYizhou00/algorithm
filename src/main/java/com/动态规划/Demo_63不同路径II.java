package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/20 14:09
 */
public class Demo_63不同路径II {
    public static void main(String[] args) {
        System.out.println(new Demo_63不同路径II().uniquePathsWithObstacles(
                new int[][]{
                        {1}
                }
        ));

    }

    int[] memo;
    int len;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        len = obstacleGrid[0].length;
        int x = obstacleGrid.length - 1;
        int y = len - 1;
        memo = new int[(x + 1) * (y + 1)];
        Arrays.fill(memo, -1);
        return dp(x, y, obstacleGrid);

    }

    public int dp(int x, int y, int[][] obstacleGrid) {

        if (x < 0 || y < 0 || obstacleGrid[x][y] == 1) return 0;
        if (x == 0 & y == 0) return 1;
        int nn = x * len + y;
        if (memo[nn] != -1) return memo[nn];
        int path = dp(x - 1, y, obstacleGrid) + dp(x, y - 1, obstacleGrid);
        memo[nn] = path;
        return path;


    }
}
