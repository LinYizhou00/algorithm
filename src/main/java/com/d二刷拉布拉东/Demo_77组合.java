package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 23:01
 */
public class Demo_77组合 {
    public static void main(String[] args) {
        Demo_77组合 demo = new Demo_77组合();
        System.out.println(demo.combine(4, 2));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;

    }

    public void backtrack(int start, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n + 1; i++) {
            path.add(i);
            backtrack(i + 1, n, k);
            path.removeLast();
        }
    }
}
