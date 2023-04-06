package com.数组;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/6 1:38
 */
public class Demo_18四数之和 {
    public static void main(String[] args) {
        Demo_18四数之和 demo = new Demo_18四数之和();
        System.out.println(demo.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int start, long target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || len < n)
            return res;
        if (n == 2) {
            int small = start, big = len - 1;
            while (small < big) {
                int left = nums[small], right = nums[big];
                int sum = left + right;
                if (sum == target) {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    small++;
                    big--;
                    while (small < big && nums[small] == left) small++;
                    while (small < big && nums[big] == right) big--;
                } else if (sum > target) {
                    big--;
                    while (small < big && nums[big] == right) big--;
                } else {
                    small++;
                    while (small < big && nums[small] == left) small++;
                }
            }
        } else {
            int i = start;
            while (i < len && (nums.length - i + 1) >= n + 1) {
                int now = nums[i];
                List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - now);
                for (List<Integer> s : sub) {
                    s.add(now);
                    res.add(s);
                }
                while (i < len && nums[i] == now) i++;
            }
        }
        return res;
    }
}
