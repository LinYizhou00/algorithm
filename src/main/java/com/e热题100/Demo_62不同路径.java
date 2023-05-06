package com.e热题100;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.Array;
import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/16 23:15
 */
public class Demo_62不同路径 {
    public static void main(String[] args) {
        System.out.println(new Demo_62不同路径().uniquePaths(
                3, 7
        ));
    }

    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m - 1, n - 1);
    }

    int dp(int x, int y) {
        if (x == 0 && y == 0) return 1;
        if (x < 0 || y < 0) return 0;
        if (memo[x][y] > 0) return memo[x][y];
        memo[x][y] = dp(x - 1, y) + dp(x, y - 1);
        return memo[x][y];
    }
}
