package com.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 20:40
 */
public class Demo_剑指Offer_II_084含有重复元素集合的全排列 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] isUsed;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        isUsed = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    public static void backtrack(int[] nums) {
        if (nums.length == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            if ((i > 0 && nums[i] == nums[i - 1]&&isUsed[i-1])) {
                continue;
            }
            isUsed[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            path.removeLast();
            isUsed[i] = false;
        }
    }
}
