package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 16:14
 */
public class Demo_27移除元素 {
    public static void main(String[] args) {
        Demo_27移除元素 demo = new Demo_27移除元素();
        System.out.println(demo.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int point = 0;
        while (point < nums.length) {
            if (nums[point] == val) {
                point++;
            } else {
                nums[index++] = nums[point++];
            }
        }


        return index;
    }
}
