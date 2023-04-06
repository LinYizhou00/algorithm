package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 9:56
 */
public class Demo_714买卖股票的最佳时机含手续费 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public static int maxProfit(int[] prices, int fee) {
        int left = 0;
        int right =  Integer.MIN_VALUE;
        int oidLeft;
        for (int price : prices) {
            oidLeft = left;
            left = Math.max(left, right + price);
            right = Math.max(right, oidLeft - price - fee);
        }
        return left;

    }
}
