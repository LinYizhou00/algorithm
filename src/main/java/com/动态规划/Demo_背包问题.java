package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/20 17:30
 */
public class Demo_背包问题 {
    public static void main(String[] args) {
        System.out.println(new Demo_背包问题().bag(
                new int[]{1, 3, 4},
                new int[]{15, 20, 30},
                4
        ));

    }

    public int bag(int[] weights, int[] values, int bagWeight) {
        int[][] dp = new int[weights.length + 1][bagWeight + 1];
        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < bagWeight + 1; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }
}
