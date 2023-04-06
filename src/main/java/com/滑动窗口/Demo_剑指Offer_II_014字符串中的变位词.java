package com.滑动窗口;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 20:29
 */
public class Demo_剑指Offer_II_014字符串中的变位词 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("cb", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int[] need = new int[26];
        int[] winds = new int[26];
        int valid = 0,  left = 0, right = 0, needSize = 0 ;
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i);
            if (need[c - 'a'] == 0) {
                needSize++;
            }
            need[c - 'a']++;
        }

        while (right < s2.length()) {
            char c = s2.charAt(right++);
            if (s1.contains(String.valueOf(c))) {
                winds[c - 'a']++;
                if (winds[c - 'a'] == need[c - 'a']) {
                    valid++;
                }
            }
            while (valid == needSize) {
                if (right - left == s1.length()) {
                    return true;
                }
                char ss = s2.charAt(left++);
                if (s1.contains(String.valueOf(ss))) {
                    if (winds[ss - 'a'] == need[ss - 'a']) {
                        valid--;
                    }
                    winds[ss - 'a']--;
                }
            }
        }

        return false;
    }
}
