package com.归并排序;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/13 19:13
 */
public class Demo_912排序数组 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));
    }

    static int[] swap;

    public static int[] sortArray(int[] nums) {
        swap = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void sort(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = start + ((end - start) >> 1);
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge1(nums, start, mid, end);

    }

    public static void merge1(int[] nums, int start, int mid, int end) {
        if (end + 1 - start >= 0) System.arraycopy(nums, start, swap, start, end + 1 - start);
        int first = start;
        int second = mid + 1;
        int index = start;
        for (int i = start; i <= end; i++) {
            if (first == mid + 1) {
                nums[index++] = swap[second++];
            } else if (second == end + 1) {
                nums[index++] = swap[first++];
            } else if (swap[first] < swap[second]) {
                nums[index++] = swap[first++];
            } else {
                nums[index++] = swap[second++];
            }
        }


    }

    public static void merge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            swap[i] = nums[i];
        }
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left != mid + 1 && right != end + 1) {
            if (swap[left] > swap[right]) {
                nums[index++] = swap[right++];
            } else {
                nums[index++] = swap[left++];
            }
        }
        if (left == mid + 1) {
            while (right < end + 1) {
                nums[index++] = swap[right++];
            }
        }
        if (right == end + 1) {
            while (left < mid + 1) {
                nums[index++] = swap[left++];
            }
        }

    }
}
