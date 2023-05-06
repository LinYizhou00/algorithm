package com.d二刷拉布拉东;

import java.util.HashSet;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 11:32
 */
public class Demo_76最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(new Demo_76最小覆盖子串().minWindow("a", "aa"));

    }

    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0;

        int[] need = new int[130];
        int[] now = new int[130];
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0, nowSize = 0;
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i) - 'A';
            need[c]++;
            set.add(c);
        }
        while (right < s.length()) {
            int c = s.charAt(right++) - 'A';
            if (set.contains(c) && ++now[c] == need[c]) {
                nowSize++;
            }
            while (left <= right && nowSize == set.size()) {
                if (right - left < min) {
                    min = right - left;
                    l = left;
                    r = right;
                }
                int cc = s.charAt(left++) - 'A';
                if (set.contains(cc) && now[cc]-- == need[cc]) {
                    nowSize--;
                }
            }


        }
        return s.substring(l, r);

    }
}
