package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 14:46
 */
public class Demo_26删除有序数组中的重复项 {
    public static void main(String[] args) {
        Demo_26删除有序数组中的重复项 demo = new Demo_26删除有序数组中的重复项();
        demo.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3});

    }

    public int removeDuplicates(int[] nums) {

        int low = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[low] == nums[fast]) {
                fast++;
            } else {
                nums[++low] = nums[fast];
            }
        }
        return low + 1;

    }
}
