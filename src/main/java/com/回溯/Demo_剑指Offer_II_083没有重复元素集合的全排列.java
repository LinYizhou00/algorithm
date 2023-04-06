package com.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/31 23:50
 */
public class Demo_剑指Offer_II_083没有重复元素集合的全排列 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    static List<List<Integer>> list = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return list;
    }
    public static void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            backtrack(nums);
            path.removeLast();
        }
    }
}
