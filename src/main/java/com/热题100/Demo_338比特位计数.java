package com.热题100;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/15 23:42
 */
public class Demo_338比特位计数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] nums = new int[n + 1];
        int index = 0;
        for (int i = 0; i <= n; i++) {
            nums[index++] = Integer.bitCount(i);
        }
        return nums;
    }
}
