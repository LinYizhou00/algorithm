package com.滑动窗口;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 10:18
 */
public class Demo_567字符串的排列 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("a", "b"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] need = new int[58];
        int[] winds = new int[58];
        int valid = 0, left = 0, right = 0,   size = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (need[c - 'A'] == 0) {
                size++;
            }
            need[c - 'A']++;
        }
        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (s1.contains(String.valueOf(c))) {
                winds[c - 'A']++;
                if (winds[c - 'A'] == need[c - 'A']) {
                    valid++;
                }
            }
            while (right - left >= s1.length() ) {
                if (valid==size){
                    return true;
                }
                char s = s2.charAt(left++);
                if (s1.contains(String.valueOf(s))) {
                    if (winds[s - 'A'] == need[s - 'A']) {
                        valid--;
                    }
                    winds[s - 'A']--;
                }
            }
        }
        return false;
    }
}
