package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 12:33
 */
public class Demo_198打家劫舍 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }


    public static int rob(int[] nums) {
        int[] dp = new int[3];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[0] = Math.max(dp[1], nums[i] + dp[2]);
            dp[2]=dp[1];
            dp[1]=dp[0];
        }
        return dp[0];
    }


}
