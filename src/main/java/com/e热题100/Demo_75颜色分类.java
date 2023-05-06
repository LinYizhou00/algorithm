package com.e热题100;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/3 9:37
 */
public class Demo_75颜色分类 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Demo_75颜色分类().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int index = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, index, i);
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, index, i);
                index++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int swap = nums[a];
        nums[a] = nums[b];
        nums[b] = swap;
    }

}

