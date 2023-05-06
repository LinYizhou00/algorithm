package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/20 21:01
 */
public class Demo_416分割等和子集 {
    public static void main(String[] args) {
        System.out.println(new Demo_416分割等和子集().canPartition(new int[]{
                1, 2, 5
        }));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int s = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][s + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[nums.length][s];

    }
}
