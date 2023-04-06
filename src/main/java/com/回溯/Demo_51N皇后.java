package com.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/31 19:35
 */
public class Demo_51N皇后 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(8).size());
    }

    static int[] path;
    static int index = 0;

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        path = new int[n];
        backtrack(n, 0, list);
        return list;
    }

    public static void backtrack(int n, int row, List<List<String>> list) {
        if (index == n) {
            list.add(toArrStr(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isCan(path, row, i)) {
                continue;
            }
            path[index++] = i;
            backtrack(n, row + 1, list);
            index--;
        }
    }

    public static List<String> toArrStr(int[] path) {
        ArrayList<String> list = new ArrayList<>();
        for (int k : path) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < path.length; j++) {
                sb.append(k == j ? "Q" : ".");
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static boolean isCan(int[] path, int row, int i) {
        for (int j = 0; j < index; j++) {
            if (path[j] == i || Math.abs(i - path[j]) == Math.abs(j - row)) return false;
        }
        return true;
    }
}
