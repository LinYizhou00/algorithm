package com.数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 15:28
 */
public class Demo_剑指Offer57和为s的两个数字 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int last = nums.length - 1, top = 0;
        int sum;int o;
        while ((sum = nums[top] + nums[last]) != target) {
           o= sum < target?top++:last--;
        }
        return new int[]{nums[top],nums[last]};

    }
}
