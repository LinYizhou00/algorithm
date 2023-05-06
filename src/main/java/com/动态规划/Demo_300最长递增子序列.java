package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/15 15:58
 */
public class Demo_300最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(new Demo_300最长递增子序列().lengthOfLIS1(new int[]{
                10, 9, 2, 5, 3, 7, 101, 18
        }));

    }

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int dui = 0;
        for (int num : nums) {
            int left = 0;
            int right = dui ;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (dp[mid] < num) {
                    left = mid + 1;
                } else if (dp[mid] > num) {
                    right = mid ;
                } else {
                    right = mid  ;
                }
            }
            if (left == dui) {

                dui++;
            }
            dp[left ] = num;
        }
        return dui;

    }

    public int lengthOfLIS(int[] nums) {

        int[] ns = new int[nums.length];
        Arrays.fill(ns, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ns[i] = Math.max(ns[j] + 1, ns[i]);
                }
            }
        }
        System.out.println(Arrays.toString(ns));
        return Arrays.stream(ns).max().getAsInt();


    }
}
