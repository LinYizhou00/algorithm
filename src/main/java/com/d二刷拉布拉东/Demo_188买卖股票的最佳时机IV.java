package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 21:38
 */
public class Demo_188买卖股票的最佳时机IV {
    public static void main(String[] args) {
        System.out.println(new Demo_188买卖股票的最佳时机IV().maxProfit(
                2, new int[]{
                        3,2,6,5,0,3
                }
        ));
    }

    public int maxProfit(int k, int[] prices) {

        int[][][] dp = new int[2][k + 1][prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[0][j][i] = 0;
                    dp[1][j][i] = -prices[i];
                    continue;
                }
                dp[0][j][i] = Math.max(dp[0][j][i - 1], dp[1][j][i - 1] + prices[i]);
                dp[1][j][i] = Math.max(dp[1][j][i - 1], dp[0][j - 1][i - 1] - prices[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][k][prices.length - 1];

    }
}
