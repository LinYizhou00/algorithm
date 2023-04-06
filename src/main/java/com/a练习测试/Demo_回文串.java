package com.a练习测试;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 15:12
 */
public class Demo_回文串 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (sc.hasNext()) {
            System.out.println(longestPalindrome(sc.next()));
        }

    }

    public static int longestPalindrome(String s) {
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
        return res.length();

    }

    public static String palindrome(String s, int first, int second) {
        while (first >= 0 && second < s.length() && s.charAt(first) == s.charAt(second)) {
            first--;
            second++;
        }
        return s.substring(first + 1, second);
    }
}
