package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 14:19
 */
public class Demo_122买卖股票的最佳时机II {
    public static void main(String[] args) {
        System.out.println(new Demo_122买卖股票的最佳时机II().maxProfit(new int[]{
                7, 1, 5, 3, 6, 4
        }));
    }

    public int maxProfit(int[] prices) {

        int first0 = 0, first1 = -prices[0], temp;
        for (int i = 1; i < prices.length; i++) {
            temp = first0;
            first0 = Math.max(first0, prices[i] + first1);
            first1 = Math.max(first1, temp - prices[i]);
        }
        return first0;

    }
}
