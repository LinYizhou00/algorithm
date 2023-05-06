package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/12 13:41
 */
public class Demo_438找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(new Demo_438找到字符串中所有字母异位词().findAnagrams1("cbaebabacd", "abc"));
    }


    public List<Integer> findAnagrams1(String s, String p) {
        short[] need = new short[26];
        short[] now = new short[26];
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = 0, nowHas = 0;
        for (int i = 0; i < p.length(); i++) {
            int c = p.charAt(i) - 'a';
            need[c]++;
            set.add(c);
        }

        while (right < s.length()) {
            int c = s.charAt(right++) - 'a';
            if (set.contains(c)) {
                if (++now[c] == need[c]) {
                    nowHas++;
                }
            }
            while (right - left >= p.length()) {
                if (set.size() == nowHas) {
                    res.add(left);
                }
                int le = s.charAt(left++) - 'a';
                if (set.contains(le) && now[le]-- == need[le]) {
                    nowHas--;
                }
            }
        }
        return res;


    }

    public List<Integer> findAnagrams(String s, String p) {
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
