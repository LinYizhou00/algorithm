package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/15 20:41
 */
public class Demo_53最大子数组和 {
    public static void main(String[] args) {
        System.out.println(new Demo_53最大子数组和().maxSubArray1(new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        }));
    }

    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int wind=0;
        int max  = Integer.MIN_VALUE;
        while (right < nums.length) {
            wind+=nums[right++];
            max=Math.max(max,wind);
            while (wind<0){
                int num = nums[left++];
                wind-=num;
            }
        }
        return max;

    }
}
