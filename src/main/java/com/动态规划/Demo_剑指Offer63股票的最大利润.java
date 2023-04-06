package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 12:14
 */
public class Demo_剑指Offer63股票的最大利润 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = Integer.MIN_VALUE;
        //dp[i][1][0]= Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i])
        //dp[i][1][1]= Math.max(dp[i-1][1][1],dp[i-1][0][0]-prices[i])
        for (int price : prices) {
            left = Math.max(left, right + price);
            right = Math.max(right, -price);
        }
        return left;
    }
}

