package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 11:50
 */
public class Demo_121买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(new Demo_121买卖股票的最佳时机().maxProfit(new int[]{
                7, 1, 5, 3, 6, 4
        }));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[1][0] = -prices[0];
                continue;
            }
            dp[0][i] = Math.max(dp[0][i - 1], prices[i] + dp[1][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 1], -prices[i]);
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[0][prices.length - 1];
    }
}
