package com.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/31 18:50
 */
public class Demo_46全排列 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList();
        backtrack(nums, 0, path);
        return list;
    }


    static List<List<Integer>> list = new ArrayList<>();

    public static void backtrack(int[] nums, int start, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.removeLast();
        }



    }

}
