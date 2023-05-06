package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 21:14
 */
public class Demo_714买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {
        System.out.println(new Demo_714买卖股票的最佳时机含手续费().maxProfit(new int[]{
                1,3,7,5,10,3
        }, 3));
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[2][prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][i] = 0;
                dp[1][i] = -prices[i];
                continue;
            }

            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i] - fee);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
        }
        return dp[0][prices.length - 1];

    }
}
