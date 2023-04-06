package com.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 9:59
 */
public class Demo_90子集II {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{0,1,0,0,1,1,0,0,0,1,0,1,0,0,0,1}));
        System.out.println(result.size());

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    static List<List<Integer>> result = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void backtrack(int[] nums, int start) {

        result.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i>start&&nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
}
