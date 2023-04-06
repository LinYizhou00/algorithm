package com.数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 14:08
 */
public class Demo_167两数之和II输入有序数组 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{-1, -1, 2, 3}, -2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int top = 0, last = numbers.length - 1;
        while (numbers[last] + numbers[top] > target) {
            last--;
        }
        int sum;
        while ((sum = numbers[top] + numbers[last]) != target) {
            if (sum > target) {
                last--;
            } else {
                top++;
            }
        }
        int[] ints = {top + 1, last + 1};
        Arrays.sort(ints);
        return ints;
    }
}
