package com.差分数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 1:12
 */
public class Demo_1094拼车 {
    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));

    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            if (trip[0] > capacity) return false;
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > capacity) return false;
        }
        return true;
    }
}
