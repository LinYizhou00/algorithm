package com.数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/31 13:42
 */
public class Demo_462最小操作次数使数组元素相等II {
    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1,10,2,9}));
    }
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = 0;
        if (nums.length % 2 != 0) {
            mid = nums[(nums.length >> 1)];
        } else {
            mid = (nums[(nums.length >> 1) - 1] + nums[nums.length >> 1]) >>1;
        }
        int count = 0;
        for (int num : nums) {
            count += Math.abs(mid - num);
        }
        return count;
    }
}
