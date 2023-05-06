package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 22:28
 */
public class Demo_47全排列II {
    public static void main(String[] args) {
        Demo_47全排列II demo = new Demo_47全排列II();
        System.out.println(demo.permuteUnique(new int[]{1,3, 2}));

    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] isUse;

    public List<List<Integer>> permuteUnique(int[] nums) {
        isUse = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0, nums.length);
        return res;
    }

    public void backtrack(int[] nums, int start, int end) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < end; i++) {
            if (i != 0 && nums[i] == nums[i - 1]&&!isUse[i-1]) continue;
            if (isUse[i]) continue;
            path.add(nums[i]);
            isUse[i] = true;
            backtrack(nums, 0, end);
            isUse[i] = false;
            path.removeLast();
        }


    }
}
