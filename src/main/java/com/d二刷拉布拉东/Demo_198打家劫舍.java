package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 21:54
 */
public class Demo_198打家劫舍 {
    public static void main(String[] args) {
        System.out.println(new Demo_198打家劫舍().rob(new int[]{
                1, 2, 3, 1
        }));
    }

    public int rob(int[] nums) {

        int f0 = 0, f1, temp;
        f1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp = f0;
            f0 = Math.max(f0, f1);
            f1 = Math.max(f1, temp + nums[i]);
        }
        return Math.max(f0, f1);
    }
}
