package com.d二刷拉布拉东;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/1 10:01
 */
public class Demo_528按权重随机选择 {
    public static void main(String[] args) {
        Demo_528按权重随机选择 x = new Demo_528按权重随机选择(new int[]{
                1, 3
        });
        System.out.println(x.pickIndex());
    }

    int[] proSum;
    int count = 0;

    public Demo_528按权重随机选择(int[] w) {
        proSum = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) {
            count += w[i];
            proSum[i + 1] = w[i] + proSum[i];
        }


    }

    public int pickIndex() {
        int j = new Random().nextInt(count) + 1;
        return search(j) - 1;
    }

    public int search(int n) {
        int left = 0;
        int right = proSum.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = proSum[mid];
            if (i > n) {
                right = mid - 1;
            } else if (i < n) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return right + 1;


    }

}
