package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 22:05
 */
public class Demo_40组合总和II {
    public static void main(String[] args) {
        Demo_40组合总和II demo = new Demo_40组合总和II();
        System.out.println(demo.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, candidates.length, target);
        return res;
    }

    public void backtrack(int[] candidates, int start, int end, int target) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < end; i++) {
            if (start!=i&&candidates[i]==candidates[i-1])continue;
            if (sum+candidates[i]>target)return;
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i + 1, end, target);
            sum -= candidates[i];
            path.removeLast();
        }


    }

}
