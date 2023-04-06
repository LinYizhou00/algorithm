package com.二分搜索;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/2 22:27
 */
public class Demo_34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = first(nums, target);
        int last = last(nums, target);
        return new int[]{first, last};

    }


    public static int first(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (target <= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < 0 || left > nums.length - 1) return -1;
        return nums[left] != target ? -1 : left;
    }

    public static int last(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (target >= num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int i = left - 1;
        if (i < 0 || i > nums.length - 1) return -1;
        return nums[i] == target ? i : -1;

    }
}
