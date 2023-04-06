package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 9:43
 */
public class Demo_309最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {

    }

    public int maxProfit_with_cool(int[] prices) {
        int left = 0, right = Integer.MIN_VALUE;
        int lastLeft = 0;
        for (int price : prices) {
            int temp = left;
            left = Math.max(left, right + price);
            right = Math.max(right, lastLeft - price);
            lastLeft = temp;
        }
        return left;
    }
}
