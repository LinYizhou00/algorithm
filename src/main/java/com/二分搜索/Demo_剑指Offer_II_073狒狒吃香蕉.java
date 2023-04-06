package com.二分搜索;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/10 0:56
 */
public class Demo_剑指Offer_II_073狒狒吃香蕉 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{312884470}, 312884469));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        if (piles.length == h) return Arrays.stream(piles).max().getAsInt();
        int left = 1, mid, i, right = (int) 1e9;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            i = hOrv(piles, mid);
            if (i <= h) right = mid - 1;
            else left = mid + 1;
        }
        return right + 1;
    }

    public static int hOrv(int[] piles, int v) {
        int h = 0;
        for (int pile : piles) {
            h += (pile % v == 0) ? (pile / v) : (pile / v + 1);
        }
        return h;
    }
}
