package com.广搜;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 16:58
 */
public class Demo_剑指Offer_II_089房屋偷盗 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 3, 3, 1}));

    }

    public static int rob(int[] nums) {
        int n1 = 0, n2 = 0, swap;
        for (int i = nums.length - 1; i >= 0; i--) {
            swap = n1;
            n1 = Math.max(n2 + nums[i], n1);
            n2 = swap;
        }
        return n1;
    }
}
