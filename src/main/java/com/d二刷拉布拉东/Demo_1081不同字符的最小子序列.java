package com.d二刷拉布拉东;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/5 16:42
 */
public class Demo_1081不同字符的最小子序列 {
    public static void main(String[] args) {
        System.out.println(new Demo_1081不同字符的最小子序列().smallestSubsequence("bcbcbcababa"));
    }

    public String smallestSubsequence(String s) {
        int[] ints = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            ints[aChar - 'a']++;
        }
        boolean[] inStack = new boolean[26];
        Deque<Character> deque = new LinkedList<>();
        for (char aChar : chars) {
            int c = aChar - 'a';
            if (inStack[c]) {
                ints[c]--;
                continue;
            }
            while (!deque.isEmpty() && deque.peek() > aChar) {
                if (ints[deque.peek() - 'a'] > 0) {
                    int nn = deque.pop() - 'a';
                    inStack[nn] = false;
                } else {
                    break;
                }
            }
            deque.push(aChar);
            ints[c]--;
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        deque.forEach(sb::append);
        return sb.reverse().toString();


    }
}
