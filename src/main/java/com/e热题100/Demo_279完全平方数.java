package com.e热题100;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/4 12:50
 */
public class Demo_279完全平方数 {
    public static void main(String[] args) {
        System.out.println(new Demo_279完全平方数().numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=i;

        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
