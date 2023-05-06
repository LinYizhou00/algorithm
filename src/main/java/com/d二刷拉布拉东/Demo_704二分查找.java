package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/12 12:56
 */
public class Demo_704二分查找 {
    public static void main(String[] args) {
        System.out.println(new Demo_704二分查找().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
