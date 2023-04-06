package com.二分搜索;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/9 23:40
 */
public class Demo_410分割数组的最大值 {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{0}, 1));

    }

    public static int splitArray(int[] nums, int k) {
        int left = 0;
        int right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = dOrw(nums, mid);
            if (i == -1) {
                left = mid + 1;
                continue;
            }
            if (i <= k) right = mid - 1;
            else left = mid + 1;
        }
        return right + 1;

    }


    public static int dOrw(int[] weights, int w) {
        int sum = 0, days = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > w) return -1;
            sum += weights[i];
            if (i == weights.length - 1)
                if (sum <= w) {
                    days++;
                    break;
                }

            if (sum > w) {
                days++;
                i--;
                sum = 0;
            }
        }
        return days;
    }
}
