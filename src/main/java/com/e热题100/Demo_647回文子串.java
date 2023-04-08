package com.e热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/14 21:33
 */
public class Demo_647回文子串 {
    public static void main(String[] args) {
        //System.out.println(isHui("abba", 0, 3));
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings1("aaa"));

    }

    static int count = 0;

    //中间扩散
    public static int countSubstrings1(String s) {

        for (int i = 0; i < s.length(); i++) {
            is(s, i, i);
            if (i != s.length() - 1) {
                is(s, i, i + 1);
            }
        }
        return count;
    }

    public static void is(String s, int start, int end) {
        if (s.charAt(start) != s.charAt(end)) {
            return;
        }
        while ((start < s.length() && start >= 0) && (end >= 0 && end < s.length()) && (s.charAt(start) == s.charAt(end))) {
            count++;
            start--;
            end++;
        }
    }

    //暴力
    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isHui(s, i, j)) count++;
            }
        }
        return count;
    }


    public static boolean isHui(String s, int start, int end) {
        if (start == end) return true;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
