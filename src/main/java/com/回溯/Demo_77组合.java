package com.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/26 11:57
 */
public class Demo_77组合 {
    public static void main(String[] args) {
        System.out.println(new Demo_77组合().combine(4, 2));
    }
    static List<List<Integer>> res = new ArrayList<>();

    static LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }
    public void backtrack(int n, int k, int start) {
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n+1; i++) {
            path.add(i);
            backtrack(n,k,i+1);
            path.removeLast();
        }
    }


}
