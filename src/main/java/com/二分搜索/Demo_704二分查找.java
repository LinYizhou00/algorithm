package com.二分搜索;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/3 20:29
 */
public class Demo_704二分查找 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = nums[mid];
            if (target > num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            } else if (target == num) {
                return mid;
            }
        }
        return -1;
    }
}
