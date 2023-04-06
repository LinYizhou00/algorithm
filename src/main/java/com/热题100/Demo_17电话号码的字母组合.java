package com.热题100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/14 23:43
 */
public class Demo_17电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("235"));

    }

    static List<String> res = new ArrayList<>();
    static LinkedList<Character> path = new LinkedList<>();
    static String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if ("".equals(digits)) return res;
        backtrack(0, digits);
        return res;
    }

    public static void backtrack(int index, String digits) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            path.forEach(sb::append);
            res.add(sb.toString());
            return;
        }
        String ss = strs[digits.charAt(index) - '0'];
        for (int i = 0; i < ss.length(); i++) {
            path.add(ss.charAt(i));
            backtrack(index + 1, digits);
            path.removeLast();
        }
    }
}

