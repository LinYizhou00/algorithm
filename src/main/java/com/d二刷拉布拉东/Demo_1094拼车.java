package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 22:45
 */
public class Demo_1094拼车 {
    public static void main(String[] args) {
        System.out.println(new Demo_1094拼车().carPooling(new int[][]{{2, 1, 5}, {
                3, 3, 7
        }}, 4));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] yuan = new int[1001];
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] = diff[trip[1]] + trip[0];
            diff[trip[2]] = diff[trip[2]] - trip[0];

        }
        for (int i = 0; i < diff.length; i++) {
            if (i == 0) {
                int n = diff[0];
                if (n > capacity) return false;
                yuan[0] = n;

                continue;
            }
            int i1 = diff[i] + yuan[i - 1];
            if (i1 > capacity) return false;
            yuan[i] = i1;

        }
        System.out.println(Arrays.toString(yuan));
        return true;


    }
}
