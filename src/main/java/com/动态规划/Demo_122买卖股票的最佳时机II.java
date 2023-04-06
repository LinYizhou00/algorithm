package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 9:30
 */
public class Demo_122买卖股票的最佳时机II {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = -Integer.MAX_VALUE;
        int oidLeft;
        for (int price : prices) {
            oidLeft = left;
            left = Math.max(left, right + price);
            right = Math.max(right, oidLeft - price);
        }
        return left;
    }
}
