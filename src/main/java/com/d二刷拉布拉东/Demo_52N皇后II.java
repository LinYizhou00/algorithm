package com.d二刷拉布拉东;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 12:29
 */
public class Demo_52N皇后II {
    public int totalNQueens(int n) {
        backtrack(n);
        return count;
    }

    int count = 0;
    LinkedList<Integer> path = new LinkedList<>();

    public void backtrack(int n) {
        if (path.size() == n) {
            count++;
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

    public boolean isCan(int x, int y) {
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == y || Math.abs(path.get(i) - y) == Math.abs(i - x))
                return false;
        }
        return true;
    }


}
