package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 20:51
 */
public class Demo_188买卖股票的最佳时机IV {
    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1}));
    }

    public static int maxProfit(int k, int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    // 处理 base case
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];


    }
}
