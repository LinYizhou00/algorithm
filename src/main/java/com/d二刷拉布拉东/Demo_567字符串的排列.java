package com.d二刷拉布拉东;

import java.util.HashSet;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/13 11:14
 */
public class Demo_567字符串的排列 {
    public static void main(String[] args) {
        System.out.println(new Demo_567字符串的排列().checkInclusion("ab", "eidboaoo"));
    }
//18

    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] now = new int[26];
        HashSet<Integer> needSet = new HashSet<>();

        int left = 0, right = 0, nowSize = 0;
        for (int i = 0; i < s1.length(); i++) {
            int s = s1.charAt(i) - 'a';
            need[s]++;
            needSet.add(s);

        }
        while (right < s2.length()) {
            int c = s2.charAt(right++) - 'a';
            if (needSet.contains(c)) {
                if (++now[c] == need[c]) {
                    nowSize++;
                }
            }

            while (right - left >= s1.length()) {
                if (needSet.size() == nowSize) {
                    return true;
                }
                int at = s2.charAt(left++) - 'a';
                if (needSet.contains(at) && now[at]-- == need[at]) {
                    nowSize--;
                }
            }

        }
        return false;


    }
}
