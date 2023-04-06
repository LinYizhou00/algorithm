package com.数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 13:50
 */
public class Demo_283移动零 {
    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes(ints);
        System.out.println(Arrays.toString(ints));

    }

    public static void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        int swap;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                swap = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = swap;
                slow++;
                fast++;
            }

        }

    }
}
