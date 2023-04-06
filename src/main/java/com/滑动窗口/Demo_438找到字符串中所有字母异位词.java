package com.滑动窗口;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 11:03
 */
public class Demo_438找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));

    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[58];
        int[] winds = new int[58];
        int needSize = 0;
        List<Integer> list = new ArrayList<>();
        Set<Integer> needSet = new HashSet<>();
        int left = 0, right = 0, valid = 0, len = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (need[c - 'A'] == 0) {
                needSet.add(c - 'A');
                needSize++;
            }
            need[c - 'A']++;
        }
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (needSet.contains(c - 'A')) {
                winds[c - 'A']++;
                if (winds[c - 'A'] == need[c - 'A']) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == needSize) {
                    list.add(left);
                }
                char c1 = s.charAt(left++);
                if (needSet.contains(c1 - 'A')) {
                    if (winds[c1 - 'A'] == need[c1 - 'A']) {
                        valid--;
                    }
                    winds[c1 - 'A']--;
                }
            }
        }
        return list;
    }
}
