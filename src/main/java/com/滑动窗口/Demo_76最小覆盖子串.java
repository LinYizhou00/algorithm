package com.滑动窗口;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/3 22:27
 */
public class Demo_76最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow("gehzduwqkzuyotckqcusdiqubeqglkvuocttzrllqfjhzorpqnjwxbqyfiesscmigicfzn", "qsvczwsslkhwg"));
    }

    public static String minWindow(String s, String t) {
        int[] need = new int[58];
        int[] window = new int[58];
        int size = 0, valid = 0;
        for (int i = 0; i < t.length(); i++) {
            int i1 = t.charAt(i) - 'A';
            int c = need[i1];
            if (c == 0) {
                size++;
            }
            need[i1]++;
        }
        int left = 0, right = 0, len = s.length() + 1, start = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (t.contains(String.valueOf(c))) {
                window[c - 'A']++;
                if (window[c - 'A'] == need[c - 'A']) {
                    valid++;
                }
            }
            while (valid == size) {
                int i = right - left;
                if (len > i) {
                    start = left;
                    len = i;
                }
                char c1 = s.charAt(left++);
                if (t.contains(String.valueOf(c1))) {
                    window[c1 - 'A']--;
                    if (window[c1 - 'A'] < need[c1 - 'A']) {
                        valid--;
                    }
                }
            }
        }
        return len > s.length() ? "" : s.substring(start, start + len);

    }


}
