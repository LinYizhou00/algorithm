package com.e热题100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/15 10:46
 */
public class Demo_79单词搜索 {
    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(chars, "ABCCED"));
    }
    static boolean isTrue = false;
    static boolean isContinue = true;
    static HashSet<String> hashSet = new HashSet<>();
    static LinkedList<String> path = new LinkedList<>();
    static HashMap<Character, ArrayList<String>> hashMap = new HashMap<>();

    public static boolean exist(char[][] board, String word) {

        if (board.length * board[0].length < word.length()) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add("" + i + j);
                hashMap.merge(board[i][j], strings, (strings1, strings2) -> {
                    strings1.addAll(strings2);
                    return strings1;
                });
            }
        }
        backtrack(0, word);
        return isTrue;
    }


    public static void backtrack(int index, String word) {
        if (path.size() == word.length()) {
            isTrue = true;
            isContinue = false;
            return;
        }
        char c = word.charAt(index);
        ArrayList<String> list = hashMap.get(c);
        if (list == null) {
            isContinue = false;
            return;
        }
        for (String e : list) {
            if (hashSet.contains(e)) continue;
            if (!isCan(path.peekLast(), e)) continue;
            path.add(e);
            hashSet.add(e);
            backtrack(index + 1, word);
            if (isTrue || !isContinue) return;
            path.removeLast();
            hashSet.remove(e);
        }

    }

    public static boolean isCan(String yuan, String check) {
        if (yuan == null) return true;
        char c = yuan.charAt(0);
        char c1 = check.charAt(0);
        char c2 = yuan.charAt(1);
        char c3 = check.charAt(1);
        if (c == c1 && Math.abs(c2 - c3) == 1) {
            return true;
        }
        return c2 == c3 && Math.abs(c - c1) == 1;
    }

}
