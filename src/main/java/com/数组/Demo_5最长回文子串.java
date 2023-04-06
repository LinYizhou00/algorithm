package com.数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 14:50
 */
public class Demo_5最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            String max = s1.length() > s2.length() ? s1 : s2;
            if (max.length() <= res.length()) {
                continue;
            }
            res = max;
        }
        return res;

    }

    public static String palindrome(String s, int first, int second) {
        while (first >= 0 && second < s.length() && s.charAt(first) == s.charAt(second)) {
            first--;
            second++;
        }
        return s.substring(first + 1, second);
    }
}
