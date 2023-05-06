package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 17:11
 */
public class Demo_283移动零 {
    public static void main(String[] args) {
        Demo_283移动零 demo = new Demo_283移动零();
        demo.moveZeroes(new int[]{1});
    }

    public void moveZeroes(int[] nums) {
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
