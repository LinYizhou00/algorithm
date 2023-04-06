package com.数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 11:33
 */
public class Demo_27移除元素 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 2, 2, 2, 3}, 2));

    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int point = 0;
        while (point < nums.length) {
            if (nums[point] != val) {
                nums[index++] = nums[point];
            }
            point++;
        }
        return index;

    }

}
