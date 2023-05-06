package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 23:09
 */
public class Demo_78子集 {
    public static void main(String[] args) {
        System.out.println(new Demo_78子集().subsets(new int[]{1, 2, 3}));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, nums.length);
        res.add(new ArrayList<>(path));
        return res;

    }

    public void backtrack(int[] nums, int start, int end) {
        if (path.size() > 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < end; i++) {
            path.add(nums[i]);
            backtrack(nums, i+1, end);
            path.removeLast();
        }

    }
}
