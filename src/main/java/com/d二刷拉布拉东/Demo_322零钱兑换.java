package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 20:42
 */
public class Demo_322零钱兑换 {
    public static void main(String[] args) {
        Demo_322零钱兑换 demo = new Demo_322零钱兑换();
        int i = demo.coinChange(new int[]{2}, 3);
        System.out.println(i);

    }

    int[] nums;

    public int coinChange(int[] coins, int amount) {
        nums = new int[amount + 1];
        Arrays.fill(nums, -2);
        return dp1(coins, amount);

    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (nums[amount] != -2) return nums[amount];
        int max = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dp = dp(coins, amount - coin);
            if (dp == -1) continue;
            max = Math.min(max, dp + 1);
        }
        nums[amount] = max == Integer.MAX_VALUE ? -1 : max;
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    int[] memo;

    public int dp1(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i < memo.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                memo[i] = Math.min(1 + memo[i - coin], memo[i]);
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];

    }
}
