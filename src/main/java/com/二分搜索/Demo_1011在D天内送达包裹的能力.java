package com.二分搜索;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/9 22:29
 */
public class Demo_1011在D天内送达包裹的能力 {
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 50000 * 500;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = dOrw(weights, mid);
            if (i == -1) {
                left = mid + 1;
                continue;
            }
            if (i <= days) right = mid - 1;
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
