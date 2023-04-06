package com.二维数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 2:10
 */
public class Demo_151反转字符串中的单词 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  Bob    Loves  Alice   "));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = reverseSpace(s);
        reverseStrings(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    public static void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 0;
        while (right < sb.length()) {
            while (right < sb.length() && sb.charAt(right) != ' ') right++;
            if (right == sb.length() - 1) {
                reverseStrings(sb, left, right);
            } else {
                reverseStrings(sb, left, right - 1);
            }
            left = ++right;
        }
    }

    public static void reverseStrings(StringBuilder sb, int start, int end) {
        char temp;
        while (start < end) {
            temp = sb.charAt(end);
            sb.setCharAt(end--, sb.charAt(start));
            sb.setCharAt(start++, temp);
        }
    }

    public static StringBuilder reverseSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;
        for (int i = left; i <= right; i++) {
            while (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                i++;
            }
            sb.append(s.charAt(i));
        }
        return sb;


    }
}
