package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/12 10:50
 */
public class Demo_34排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Demo_34排序数组中查找元素的第一个和最后一个位置().searchRange(
                new int[]{10}, 6
        )));

    }

    public int[] searchRange(int[] nums, int target) {
        Arrays.sort(nums);
        return new int[]{findFirstIndex(nums, target), findLastIndex(nums, target)};

    }

    public int findFirstIndex(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return (left < 0 || left >= nums.length || nums[left] != target) ? -1 : left;

    }

    public int findLastIndex(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return (right >= nums.length || right < 0 || nums[right] != target) ? -1 : right;

    }
}
