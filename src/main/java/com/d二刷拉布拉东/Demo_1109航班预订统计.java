package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 23:03
 */
public class Demo_1109航班预订统计 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Demo_1109航班预订统计().corpFlightBookings(new int[][]
                {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5
        )));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ints = new int[n + 1];
        for (int[] booking : bookings) {
            int a = booking[0];
            int b = booking[1];
            int c = booking[2];
            ints[a - 1] += c;
            ints[b] -= c;
        }
        for (int i = 1; i < n; i++) {
            ints[i] = ints[i - 1] + ints[i];
        }
        return Arrays.copyOf(ints, ints.length - 1);

    }
}
