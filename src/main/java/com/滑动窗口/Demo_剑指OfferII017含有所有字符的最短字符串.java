package com.滑动窗口;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 19:49
 */
public class Demo_剑指OfferII017含有所有字符的最短字符串 {
    public static void main(String[] args) {
        //    分析复杂度
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int[] need = new int[200];
        int[] winds = new int[200];
        int valid = 0, start = 0, left = 0, right = 0, needSize = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            if (need[c] == 0) {
                needSize++;
            }
            need[c]++;
        }

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (t.contains(String.valueOf(c))) {
                winds[c]++;
                if (winds[c] == need[c]) {
                    valid++;
                }
            }
            while (valid == needSize) {
                int i = right - left;
                if (i < len) {
                    len = i;
                    start = left;
                }

                char ss = s.charAt(left++);
                if (t.contains(String.valueOf(ss))) {

                    if (winds[ss] == need[ss]) {
                        valid--;
                    }
                    winds[ss]--;
                }

            }


        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }
}
