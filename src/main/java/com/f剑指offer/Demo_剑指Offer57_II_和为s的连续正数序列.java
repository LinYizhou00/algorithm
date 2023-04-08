package com.f剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/7 0:57
 */
public class Demo_剑指Offer57_II_和为s的连续正数序列 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(15)));
    }

    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        int max = (int) (target / 2.0 + 0.5);
        int left = 1;
        int right = 2;
        int sum = 1;
        while (right <= max + 1 && left < right) {
            while (sum < target) {
                sum += right++;
            }
            if (sum == target) {
                int[] nums = new int[right - left];
                int index = 0;
                for (int i = left; i < right; i++) {
                    nums[index++] = i;
                }
                list.add(nums);
                sum -= left++;
            } else if (sum > target) {
                while (sum > target) {
                    sum -= left++;
                }
            }
        }

        return list.toArray(new int[list.size()][]);


    }
}
