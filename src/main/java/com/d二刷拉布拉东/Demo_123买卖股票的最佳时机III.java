package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 15:09
 */
public class Demo_123买卖股票的最佳时机III {
    public static void main(String[] args) {
        System.out.println(new Demo_123买卖股票的最佳时机III().maxProfit(new int[]{
                3, 3, 5, 0, 0, 3, 1, 4
        }));
    }

    public int maxProfit(int[] prices) {
        int max = 2;
        int[][][] dp = new int[prices.length][max + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = max; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j-1][1] = -prices[0];

                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[prices.length - 1][max][0];
    }
}
