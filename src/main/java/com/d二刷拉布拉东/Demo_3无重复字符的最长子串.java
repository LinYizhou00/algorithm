package com.d二刷拉布拉东;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/12 13:15
 */
public class Demo_3无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(new Demo_3无重复字符的最长子串().lengthOfLongestSubstring1("bbb"));

    }

    public int lengthOfLongestSubstring1(String s) {
        byte[] bytes = new byte[200];
        int left = 0;
        int right = 0;
        int max = -1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (bytes[c] == 0) {
                bytes[c]++;
                right++;
            } else {
                max = Math.max(max, right - left);
                while (bytes[c] != 0) {
                    bytes[s.charAt(left++)]--;
                }
            }
        }
        return Math.max(max, right - left);

    }

    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        LinkedList<Character> queue = new LinkedList<>();
        int index = 0;
        while (index < s.length()) {
            if (!queue.contains(s.charAt(index))) {
                queue.offer(s.charAt(index++));
            } else {
                max = Math.max(max, queue.size());
                while (queue.contains(s.charAt(index))) {
                    queue.pollFirst();
                }
            }
        }
        return Math.max(max, queue.size());
    }
}
