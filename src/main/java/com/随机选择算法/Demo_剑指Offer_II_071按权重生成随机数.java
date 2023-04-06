package com.随机选择算法;

import java.util.Random;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/8 11:20
 */
public class Demo_剑指Offer_II_071按权重生成随机数 {
    int[] preSum;

    public Demo_剑指Offer_II_071按权重生成随机数(int[] w) {
        preSum = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) preSum[i + 1] = preSum[i] + w[i];
    }

    public int pickIndex() {
        int r = new Random().nextInt(preSum[preSum.length - 1]) + 1;
        int left = 0, right = preSum.length - 1, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (preSum[mid] == r) {
                left = mid;
                break;
            } else if (preSum[mid] > r) right = mid - 1;
            else left = mid + 1;
        }
        return left - 1;
    }

}
