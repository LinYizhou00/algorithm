package com.d二刷拉布拉东;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/30 21:11
 */
public class Demo_151反转字符串中的单词 {
    public static void main(String[] args) {
        System.out.println(new Demo_151反转字符串中的单词().reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        s = s.replaceAll(" +", " ").trim();
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                reverse(chars, start, i);
                continue;
            }
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        return new String(chars);
    }

    public void reverse(char[] s, int start, int end) {
        int l = start;
        int r = end;
        char c;
        while (l < r) {
            c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }
    }
}
