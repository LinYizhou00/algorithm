package com.d二刷拉布拉东;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/14 23:01
 */
public class Demo_15三数之和 {
    public static void main(String[] args) {
        System.out.println(new Demo_15三数之和().threeSum(new int[]{
                -1, 0, 1, 2, -1, -4
        }));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3 || nums[0] > 0) {
            return res;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int count = 0;
            int right = nums.length - 1;
            while (left < right) {

                int tar = nums[left] + nums[right];
                if (tar > -nums[i]) {
                    right--;
                    while (nums[right] == nums[right + 1]) right--;
                } else if (tar < -nums[i]) {
                    left++;
                    while (nums[left] == nums[left - 1]) left++;
                } else {
                    count++;
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]++);
                    list.add(nums[right--]);
                    list.add(nums[i]);
                    res.add(list);
                    while (nums[right] == nums[right + 1]) right--;
                    while (nums[left] == nums[left - 1]) left++;
                }
            }
            if (count > 0) {
                while (i != 0 && nums[i] == nums[i - 1]) i++;
                count = 0;
            }

        }
        return res;


    }
}
