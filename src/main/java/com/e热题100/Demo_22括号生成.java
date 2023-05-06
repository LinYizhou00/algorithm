package com.e热题100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/1 11:28
 */
public class Demo_22括号生成 {
    public static void main(String[] args) {
        System.out.println(new Demo_22括号生成().generateParenthesis(3));
    }

    LinkedList<String> path = new LinkedList<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, n);
        return res;
    }

    public void backtrack(int left, int right) {
        if (left < 0 || right < 0 || right < left) return;
        if (left == 0 && right == 0) {
            res.add(path.toString().replace(", ", "")
                    .replace("[", "").replace("]", ""));
            return;
        }

        if (left > 0) {
            path.offer("(");
            backtrack(left - 1, right);
            path.removeLast();
        }
        path.offer(")");
        backtrack(left, right - 1);
        path.removeLast();

    }
}
