package com.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/8 0:11
 */
public class Demo_187重复的DNA序列 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(findRepeatedDnaSequences1("AAAAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        int[] ss = new int[s.length()];
        for (int i = 0; i < ss.length; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    ss[i] = 0;
                    break;
                case 'C':
                    ss[i] = 1;
                    break;
                case 'G':
                    ss[i] = 2;
                    break;
                case 'T':
                    ss[i] = 3;
                    break;
                default:
            }

        }
        Set<Integer> seen = new HashSet<>();
        Set<String> res = new HashSet<>();

        //进制
        int R = 4;
        int num = 0;
        //位数
        int L = 10;
        int left = 0;
        int right = 0;
        while (right < ss.length) {
            int s1 = ss[right];
            num = num * R + s1;
            if (right - left == L - 1) {
                if (seen.contains(num)) {
                    res.add(s.substring(left, right + 1));
                } else {
                    seen.add(num);
                }
                num = num - ss[left] * (int) Math.pow(R, L - 1.0);
                left++;
            }
            right++;
        }
        return new ArrayList<>(res);


    }

    //暴力
    public static List<String> findRepeatedDnaSequences1(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i + 10 < s.length() + 1; i++) {
            String substring = s.substring(i, i + 10);
            if (seen.contains(substring)) {
                res.add(substring);
            } else {
                seen.add(substring);
            }
        }
        return new ArrayList<>(res);
    }
}
