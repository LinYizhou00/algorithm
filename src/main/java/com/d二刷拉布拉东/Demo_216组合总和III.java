package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 12:35
 */
public class Demo_216组合总和III {
    public static void main(String[] args) {
        Demo_216组合总和III demo = new Demo_216组合总和III();
        System.out.println(demo.combinationSum3(3, 7));
    }

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, 10, k, n);
        return res;
    }

    public void backtrack(int start, int end, int num, int allSum) {
        if (sum == allSum && path.size() == num) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < end; i++) {
            if (sum + i > allSum && path.size() + 1 > num) return;
            path.add(i);
            sum += i;
            backtrack(i + 1, end, num, allSum);
            Integer last = path.removeLast();
            sum -= last;
        }
    }
}
