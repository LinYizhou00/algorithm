package com.二分搜索;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/9 18:48
 */
public class Demo_875爱吃香蕉的珂珂 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println((long) 10e9);
        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles, 5));
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));

    }

    public static int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long right = (long) 10e9;
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            if (vOrt(piles, mid) > h) left = mid + 1;
            else right = mid - 1;
        }
        return (int) right + 1;
    }

    public static int vOrt(int[] piles, long v) {
        int hour = 0;
        for (int pile : piles) {
            long h = pile / v;
            hour += (pile % v != 0 ? h + 1 : h);
        }

        return hour;
    }
}
