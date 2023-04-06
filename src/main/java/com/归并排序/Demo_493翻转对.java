package com.归并排序;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/14 10:28
 */
public class Demo_493翻转对 {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{5, 4, 3, 2, 1}));
    }

    static int count = 0;
    static int[] temp;

    public static int reversePairs(int[] nums) {
        if (nums.length == 0) return count;
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return count;
    }

    public static void sort(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = start + ((end - start) >> 1);
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int lo, int mid, int hi) {
        if (hi + 1 - lo >= 0) System.arraycopy(nums, lo, temp, lo, hi + 1 - lo);


        int end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (end <= hi && (long) nums[i] > (long) nums[end] * 2) {
                end++;
            }
            count += end - (mid + 1);
        }


        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
