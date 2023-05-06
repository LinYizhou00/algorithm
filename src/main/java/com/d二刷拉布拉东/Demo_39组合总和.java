package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 13:23
 */
public class Demo_39组合总和 {
    public static void main(String[] args) {
        Demo_39组合总和 demo = new Demo_39组合总和();
        List<List<Integer>> lists = demo.combinationSum(new int[]{2, 3,5}, 8);
        System.out.println(lists);

    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, candidates.length, target);
        return res;


    }

    public void backtrack(int[] candidates, int start, int end, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < end; i++) {
            if (sum + candidates[i] > target) return;
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, i, end, target);
            sum -= candidates[i];
            path.removeLast();

        }


    }

}
