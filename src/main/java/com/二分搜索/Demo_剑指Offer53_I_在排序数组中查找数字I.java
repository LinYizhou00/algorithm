package com.二分搜索;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/3 20:39
 */
public class Demo_剑指Offer53_I_在排序数组中查找数字I {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    public static int search(int[] nums, int target) {
        int first = first(nums, target);
        if (first == -1) {
            return 0;
        }
        int last = last(nums, target);
        return last-first+1;
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
}
