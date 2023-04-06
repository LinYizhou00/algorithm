package com.差分数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 0:52
 */
public class Demo_1109航班预订统计 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                corpFlightBookings(new int[][]{
                                {1, 2, 10},
                                {2, 3, 20},
                                {2, 5, 25}},
                        5)));

    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] < diff.length) {
                diff[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i - 1] + diff[i];
        }
        return diff;
    }

}