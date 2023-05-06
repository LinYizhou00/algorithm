package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/5 14:58
 */
public class Demo_1011在D天内送达包裹的能力 {
    public static void main(String[] args) {

        System.out.println(new Demo_1011在D天内送达包裹的能力().shipWithinDays(new int[]{
                500
        }, 1));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = (int) 5e4 * 500;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int i = weightWithDays(weights, mid);
            if (i == -1) {
                left = mid + 1;
                continue;
            }
            if (i < days) {
                right = mid - 1;
            } else if (i > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return left;

    }

    public int weightWithDays(int[] weights, int weight) {
        int days = 0;
        int w = weight;
        for (int i = 0; i < weights.length; i++) {
            int wei = weights[i];
            if (wei > weight) return -1;
            if (wei > w) {
                days++;
                w = weight;
                i--;

            } else if (w == wei) {
                days++;
                w = weight;
            } else {
                w -= wei;
            }
        }
        if (w != weight) {
            days++;
        }
        return days;


    }
}
