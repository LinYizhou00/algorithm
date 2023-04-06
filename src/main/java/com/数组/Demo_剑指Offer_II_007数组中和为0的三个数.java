package com.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/6 2:02
 */
public class Demo_剑指Offer_II_007数组中和为0的三个数 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,1, -2, 1}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        return nSum(nums, 3, 0, 0);

    }

    static int count = 0;
    static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("   ");
        }
    }

    public static List<List<Integer>> nSum(int[] nums, int n, int start, int target) {



        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || nums.length < n) return res;
        if (nums[start] > target) return res;
        if (n == 2) {
            int L = start;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[L] + nums[R];
                if (sum < target) {
                    L++;
                    while (L < R && nums[L] == nums[L - 1]) L++;

                } else if (sum > target) {
                    R--;
                    while (L < R && nums[R] == nums[R + 1]) R--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[L++], nums[R--])));
                    while (L < R && nums[R] == nums[R + 1]) R--;
                    while (L < R && nums[L] == nums[L - 1]) L++;
                }
            }
        } else {
            int i = start;
            while (i < nums.length && (nums.length - i + 1) >= n + 1) {
                int now = nums[i];
                List<List<Integer>> tempList = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : tempList) {
                    list.add(nums[i]);
                    res.add(list);
                }
                i++;
                while (i < nums.length && nums[i] == now) i++;

            }
        }
        return res;
    }
}