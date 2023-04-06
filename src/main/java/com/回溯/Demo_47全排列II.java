package com.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 10:33
 */
public class Demo_47全排列II {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 2}));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        isUse = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums, path);
        return list;
    }

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] isUse;


    public static void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUse[i]||(i > 0 && nums[i] == nums[i - 1] && !isUse[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            isUse[i] = true;
            backtrack(nums,  path);
            path.removeLast();
            isUse[i] = false;
        }
    }
}
