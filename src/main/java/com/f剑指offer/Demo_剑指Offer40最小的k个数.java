package com.f剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 22:56
 */
public class Demo_剑指Offer40最小的k个数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = queue.poll();
        }


        return nums;
    }
}
