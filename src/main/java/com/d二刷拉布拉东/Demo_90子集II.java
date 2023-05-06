package com.d二刷拉布拉东;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 23:20
 */
public class Demo_90子集II {
    public static void main(String[] args) {
        System.out.println(new Demo_90子集II().subsetsWithDup(new int[]{1, 2, 2}));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, nums.length);
        res.add(new ArrayList<>(path));
        return res;

    }

    public void backtrack(int[] nums, int start, int end) {
        if (path.size() > 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < end; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(nums, i + 1, end);
            path.removeLast();
        }

    }
}
