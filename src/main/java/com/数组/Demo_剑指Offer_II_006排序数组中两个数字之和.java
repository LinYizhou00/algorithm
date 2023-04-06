package com.数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 15:35
 */
public class Demo_剑指Offer_II_006排序数组中两个数字之和 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        int last = numbers.length - 1, top = 0;
        int sum;
        int o;
        while ((sum = numbers[top] + numbers[last]) != target) {
            o = sum < target ? top++ : last--;
        }

        return new int[]{top, last};
    }
}
