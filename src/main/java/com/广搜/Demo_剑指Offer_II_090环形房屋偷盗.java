package com.广搜;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 17:03
 */
public class Demo_剑指Offer_II_090环形房屋偷盗 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 3, 3, 1}));

    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(dp(nums, 0, nums.length - 1), dp(nums, 1, nums.length));
    }

    public static int dp(int[] nums, int start, int end) {
        int n1 = 0, n2 = 0, swap;
        for (int i = end - 1; i >= start; i--) {
            swap = n1;
            n1 = Math.max(n2 + nums[i], n1);
            n2 = swap;
        }
        return n1;
    }
}
