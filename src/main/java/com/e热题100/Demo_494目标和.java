package com.e热题100;

import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/4 17:35
 */
public class Demo_494目标和 {
    public static void main(String[] args) {
        System.out.println(new Demo_494目标和().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return result;
    }

    int result = 0;

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length && sum == target) {
            result++;
        }
        if (index < nums.length) {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
