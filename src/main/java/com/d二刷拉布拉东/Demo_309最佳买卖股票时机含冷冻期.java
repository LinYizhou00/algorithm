package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 17:13
 */
public class Demo_309最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        System.out.println(new Demo_309最佳买卖股票时机含冷冻期().maxProfit(new int[]{
                1, 2, 4
        }));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][i] = 0;
                dp[1][i] = -prices[i];
                continue;
            }
            if (i == 1) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
                dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
                continue;
            }

            dp[0][i] = Math.max(dp[0][i - 1], prices[i] + dp[1][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 2] - prices[i]);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][prices.length - 1];

    }
}
