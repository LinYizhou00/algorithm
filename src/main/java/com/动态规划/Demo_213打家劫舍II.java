package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 15:34
 */
public class Demo_213打家劫舍II {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
    }
    public static int rob(int[] nums) {
        if (nums.length<2)return nums[0] ;
        return Math.max(dp(nums, 0, nums.length - 1), dp(nums, 1, nums.length));
    }
    public static int dp(int[] nums, int start, int end) {
        int n1 = 0, n2 = 0, swap;
        for (int i = start; i < end; i++) {
            swap = n1;
            n1 = Math.max(n2 + nums[i], n1);
            n2 = swap;
        }
        return n1;
    }
}
