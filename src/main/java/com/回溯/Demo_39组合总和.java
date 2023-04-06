package com.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 15:25
 */
public class Demo_39组合总和 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target);
        return res;
    }

    public static void backtrack(int[] candidates, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int candidate : candidates) {
            if (candidate > target) {
                break;
            }
            if (path.size() > 0 && path.getLast() > candidate) continue;
            path.add(candidate);
            sum += candidate;
            backtrack(candidates, target);
            sum -= candidate;
            path.removeLast();
        }
    }

}
