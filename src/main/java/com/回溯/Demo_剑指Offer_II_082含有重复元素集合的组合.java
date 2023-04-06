package com.回溯;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 20:57
 */
public class Demo_剑指Offer_II_082含有重复元素集合的组合 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);

        return res;
    }

    public static void backtrack(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i + 1);
            path.removeLast();
            sum -= candidates[i];
        }


    }
}
