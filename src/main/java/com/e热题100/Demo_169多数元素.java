package com.e热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/15 23:57
 */
public class Demo_169多数元素 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4}));
    }

    public static int majorityElement(int[] nums) {
        int num = 0;
        int count = 0;
        for (int j : nums) {
            if (count == 0) {
                num = j;
                count++;
            } else if (num != j) {
                count--;
            } else {
                count++;
            }
        }
        return num;
    }
}
