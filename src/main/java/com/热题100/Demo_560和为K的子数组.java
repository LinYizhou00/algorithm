package com.热题100;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/16 11:08
 */
public class Demo_560和为K的子数组 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 0, 3}, 3));
    }

    //有点像两数之差
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int t = sum[i];
            int d = t - k;
            ans += map.getOrDefault(d, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return ans;
    }
}
