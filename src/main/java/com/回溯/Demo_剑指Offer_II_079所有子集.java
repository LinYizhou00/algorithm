package com.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 21:17
 */
public class Demo_剑指Offer_II_079所有子集 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();



    public static void main(String[] args) {
        System.out.println(subsets(new int[]{0,1,0,0,1,1,0,0,0,1,0,1,0,0,0,1}));
        System.out.println(res.size());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;

    }

    public static void backtrack(int[] nums,int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length ; i++) {
            path.add(nums[i]);
            backtrack(nums,i+1);
            path.removeLast();
        }


    }
}
