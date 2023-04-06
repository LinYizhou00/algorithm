package com.滑动窗口;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 20:34
 */
public class Demo_剑指Offer48最长不含重复字符的子字符串 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()<2)return s.length();
        int[] winds = new int[200];
        int   left = 0, right = 0,  len = -1;
        while (right < s.length()) {
            char c = s.charAt(right++);
            winds[c]++;
            while (winds[c] > 1) {
                char ss = s.charAt(left++);
                winds[ss]--;
            }
            len=Math.max(right - left,len)  ;
        }
        return len == -1 ? 0 :  len ;
    }
}
