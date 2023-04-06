package com.回溯;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/1 21:20
 */
public class Demo_剑指Offer_II_080含有k个元素的组合 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));

    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    public static void backtrack(int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n + 1; i++) {
            path.add(i);
            backtrack(n, k, i + 1);
            path.removeLast();

        }

    }
}
