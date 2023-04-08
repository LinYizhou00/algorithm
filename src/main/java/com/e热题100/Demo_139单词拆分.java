package com.e热题100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/16 20:01
 */
public class Demo_139单词拆分 {
    //超时！！
    public static void main(String[] args) {
        //System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        //System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    static LinkedList<String> path = new LinkedList<>();

    static int length = 0;
    static boolean isCan = false;
    static boolean isCon = true;

    public static boolean wordBreak(String s, List<String> wordDict) {
        backtrack(s, wordDict);
        return isCan;
    }

    public static void backtrack(String s, List<String> wordDict) {
        if (s.length() == length && getStr(path).equals(s)) {
            isCan = true;
            isCon = false;
            System.out.println(path);
            return;
        }


        for (int i = 0; i < wordDict.size(); i++) {
            String s1 = wordDict.get(i);
            if (length >= s.length()) continue;
            path.add(s1);
            length += s1.length();
            backtrack(s, wordDict);
            if (!isCon) return;
            String s2 = path.removeLast();
            length -= s2.length();
        }


    }

    public static String getStr(List<String> path) {
        StringBuilder sb = new StringBuilder();
        for (String s : path) {
            sb.append(s);

        }
        return sb.toString();


    }
}
