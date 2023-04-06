package com.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/5 22:40
 */
public class Demo_15三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> tempRes = new ArrayList<>();
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[R] + nums[L];
                if (sum < -nums[i]) {
                    L++;
                    while (L < R && nums[L] == nums[L - 1]) L++;
                } else if (sum > -nums[i]) {
                    R--;
                    while (L < R && nums[R] == nums[R + 1]) R--;
                } else {
                    tempRes.add(Arrays.asList(nums[i], nums[R--], nums[L++]));
                    while (L < R && nums[R] == nums[R + 1]) R--;
                    while (L < R && nums[L] == nums[L - 1]) L++;
                }
            }
            if (tempRes.size() != 0) {
                res.addAll(tempRes);
                while (i < nums.length - 2 && nums[i + 1] == nums[i]) i++;
            }
        }
        return res;
    }



}
