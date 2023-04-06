package com.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 10:10
 */
public class Demo_40组合总和II {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12}, 27));
    }
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int sum = 0;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }
    public static void backtrack(int[] candidate, int start, int target) {
        if (sum>target){
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidate.length; i++) {
            if (i > start && candidate[i] == candidate[i - 1]) continue;
            if (candidate[i] > target) {
                break;
            }
            path.add(candidate[i]);
            sum+=candidate[i];
            backtrack(candidate, i + 1, target);
            sum-=path.removeLast();
        }

    }


}
