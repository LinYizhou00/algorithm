package com.回溯;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 21:24
 */
public class Demo_剑指Offer_II_081允许重复选择元素的组合 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (sum+candidates[i] > target) {
                break;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, i);
            path.removeLast();
            sum -= candidates[i];

        }

    }
}
