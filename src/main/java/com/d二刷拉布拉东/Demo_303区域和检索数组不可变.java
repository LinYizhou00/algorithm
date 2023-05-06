package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 19:37
 */
public class Demo_303区域和检索数组不可变 {
    int[] preSum;

    public Demo_303区域和检索数组不可变(int[] nums) {
        preSum = new int[nums.length + 1];

        preSum[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];

        }

    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];

    }

    public static void main(String[] args) {
        System.out.println(new Demo_303区域和检索数组不可变(new int[]{
                -2, 0, 3, -5, 2, -1
        }).sumRange(0, 5));

    }
}
