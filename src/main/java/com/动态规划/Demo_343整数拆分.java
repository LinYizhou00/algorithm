package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/20 14:22
 */
public class Demo_343整数拆分 {
    public static void main(String[] args) {
        System.out.println(new Demo_343整数拆分().integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            for (int j = i - 1; j >= i / 2; j--) {
                int max = Math.max(j * (i - j), dp[j] * (i - j));
                dp[i] = Math.max(dp[i], max);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];

    }
}
