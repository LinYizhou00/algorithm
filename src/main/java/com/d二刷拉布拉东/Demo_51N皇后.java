package com.d二刷拉布拉东;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 11:03
 */


public class Demo_51N皇后 {
    public static void main(String[] args) {
        Demo_51N皇后 demo = new Demo_51N皇后();
        System.out.println(demo.solveNQueens(4));
    }

    List<List<String>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(n);
        return res;
    }

    public void backtrack(int n) {
        if (path.size() == n) {
            res.add(toStr(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isCan(path.size(), i)) {
                continue;
            }
            path.add(i);
            backtrack(n);
            path.removeLast();
        }
    }


    public boolean isCan(int x,int y) {
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == y || Math.abs(path.get(i) - y) == Math.abs(i - x))
                return false;
        }
        return true;
    }

    public List<String> toStr(LinkedList<Integer> pat) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < pat.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pat.size(); j++) {
                sb.append(pat.get(i) == j ? "Q" : ".");
            }
            list.add(sb.toString());
        }
        return list;
    }


}
