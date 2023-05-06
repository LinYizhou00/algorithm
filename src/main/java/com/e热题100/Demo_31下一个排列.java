package com.e热题100;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/3 0:51
 */
public class Demo_31下一个排列 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        new Demo_31下一个排列().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            Arrays.sort(nums);
            return;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
        Arrays.sort(nums, i + 1, nums.length);
    }
}
