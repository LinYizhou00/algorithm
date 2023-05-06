package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 22:21
 */
public class Demo_213打家劫舍II {
    public static void main(String[] args) {
        System.out.println(new Demo_213打家劫舍II().rob(new int[]{
                2, 3, 2
        }));
    }

    public int rob(int[] nums) {
        if (nums.length < 3) {
            return Math.max(nums[0], nums[nums.length - 1]);
        }
        int a = robRange(nums, 0, nums.length - 2);
        int b = robRange(nums, 1, nums.length - 1);
        return Math.max(a, b);

    }

    public int robRange(int[] nums, int start, int end) {

        int[] dp = new int[end + 1 + 2];
        for (int i = start + 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 2] + dp[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[end + 2];

    }
}
