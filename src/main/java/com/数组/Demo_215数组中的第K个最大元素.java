package com.数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 9:18
 */
public class Demo_215数组中的第K个最大元素 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 7, 0, 1, 2};
        System.out.println(findKthLargest(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public static int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) lo = p + 1;
            else if (p > k) hi = p - 1;
            else return nums[p];
        }
        return -1;
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partition(int[] nums, int left, int right) {
        int pro = nums[left];
        int i = left + 1, j = right;
        while (i <= j) {
            while (i < right && nums[i] <= pro) i++;
            while (j > left && nums[j] > pro) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

}
