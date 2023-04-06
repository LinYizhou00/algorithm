package com.数组;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 17:07
 */
public class Demo_1两数之和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));
        System.out.println(twoSumTarget(new int[]{1, 3, 1, 2, 2, 3}, 4));
    }

    //改版两数之和
    public static List<List<Integer>> twoSumTarget(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int last = nums.length - 1;
        while (left < last) {
            if (nums[last] + nums[left] < target) {
                left++;
                while (left < last && nums[left] == nums[left - 1]) left++;
            }
            if (nums[last] + nums[left] > target) {
                last--;
                while (left < last && nums[last] == nums[last + 1]) last--;
            }
            if (nums[last] + nums[left] == target) {
                res.add(Arrays.asList(nums[last--], nums[left++]));
                while (left < last && nums[last] == nums[last + 1]) last--;
                while (left < last && nums[left] == nums[left - 1]) left++;
            }
        }
        return res;
    }

    //1两数之和改返回数字
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int last = nums.length - 1;
        while (left < last) {
            if (nums[last] + nums[left] < target) {
                left++;
            }
            if (nums[last] + nums[left] > target) {
                last--;
            }
            if (nums[last] + nums[left] == target) {
                return new int[]{nums[last], nums[left]};
            }
        }
        return new int[]{};
    }


}
