package com.回溯;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/26 13:34
 */
public class Demo_216组合总和III {
    public static void main(String[] args) {
        System.out.println(new Demo_216组合总和III().combinationSum3(4, 20));
    }


    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = combine(9, k);
        Iterator<List<Integer>> iterator = list.iterator();
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            int sum = 0;
            for (Integer integer : next) {
                sum += integer;
            }
            if (sum != n) {
                iterator.remove();
            }
        }
        return list;
    }
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }
    public void backtracking(int n, int k, int indexStart) {
        if (path.size() == k&&sum==n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = indexStart; i <= n - (k - path.size()) + 1; i++) {
            sum+=i;
            path.add(i);
            backtracking(n, k, i + 1);
            sum-=i;
            path.removeLast();

        }
    }
}
