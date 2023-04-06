package com.滑动窗口;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 20:05
 */
public class Demo_剑指Offer_II_016不含重复字符的最长子字符串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }

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
