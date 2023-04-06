package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 21:04
 */
public class Demo_121买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            left = Math.max(left, right + prices[i]);
            right = Math.max(right, -prices[i]);
        }
        return left;
    }

    public static void toPrint(int[][] nums) {
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));

        }
    }

}
