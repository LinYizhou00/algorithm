package com.滑动窗口;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 12:25
 */
public class Demo_3无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left=0,right=0,res=0;
        int[] winds = new int[200];
        while (right<s.length()) {
            int c = s.charAt(right++);
            winds[c]++;
            while (winds[c]>1){
                char c1 = s.charAt(left++);
                winds[c1]--;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int[] set = new int[200];
        Queue<Integer> queue = new LinkedList<>();
        int index = 0,length = 0;
        while (index < s.length()) {
            int c = s.charAt(index++);
            if (set[c] == 0) {
                set[c]++;
            } else {
                while (true) {
                    Integer poll = queue.poll();
                    if (poll == c) {
                        break;
                    } else {
                        set[poll]--;
                    }
                }
            }
            queue.add(c);
            length = Math.max(length, queue.size());
        }
        return length;


    }
}
