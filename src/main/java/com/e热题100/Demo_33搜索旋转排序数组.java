package com.e热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/2 22:29
 */
public class Demo_33搜索旋转排序数组 {
    public static void main(String[] args) {
        System.out.println(new Demo_33搜索旋转排序数组().search(new int[]{5, 1, 3}, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;

    }
}
