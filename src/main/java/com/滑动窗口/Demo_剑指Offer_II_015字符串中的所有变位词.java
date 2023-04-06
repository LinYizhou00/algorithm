package com.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 20:22
 */
public class Demo_剑指Offer_II_015字符串中的所有变位词 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s==null||p==null||p.equals("")){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int[] need = new int[200];
        int[] winds = new int[200];
        int valid = 0,   left = 0, right = 0, needSize = 0  ;
        for (int i = 0; i < p.length(); i++) {
            int c = p.charAt(i);
            if (need[c] == 0) {
                needSize++;
            }
            need[c]++;
        }

        while (right < s.length()) {
            char c = s.charAt(right++);
            if (p.contains(String.valueOf(c))) {
                winds[c]++;
                if (winds[c] == need[c]) {
                    valid++;
                }
            }
            while (valid == needSize) {
                if (right-left==p.length()){
                    list.add(left);
                }

                char ss = s.charAt(left++);
                if (p.contains(String.valueOf(ss))) {

                    if (winds[ss] == need[ss]) {
                        valid--;
                    }
                    winds[ss]--;
                }

            }


        }

        return list;

    }
}
