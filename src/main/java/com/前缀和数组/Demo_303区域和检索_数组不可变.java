package com.前缀和数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/6 20:46
 */
public class Demo_303区域和检索_数组不可变 {
    public static void main(String[] args) {
        int[] ints = {-2, 0, 3, -5, 2, -1};
        Demo_303区域和检索_数组不可变 demo = new Demo_303区域和检索_数组不可变(ints);
        System.out.println(sumRange(2, 5));
    }

    static int[] sums;

    public Demo_303区域和检索_数组不可变(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    public static int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
