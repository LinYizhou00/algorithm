package com.单调栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/11 13:39
 */
public class Demo_316去除重复字母 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("acba"));
    }

    public static String removeDuplicateLetters(String s) {
        boolean[] booleans = new boolean[26];
        Deque<Character> characters = new LinkedList<>();
        int[] counts = new int[26];
        char c;
        Character peek;
        Character pop;
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!booleans[c - 'a']) {
                while (!characters.isEmpty() && characters.peek() > c) {
                    peek = characters.peek();
                    if (counts[peek - 'a'] > 0) {
                        pop = characters.pop();
                        booleans[pop - 'a'] = false;
                    } else {
                        break;
                    }
                }
                characters.push(c);
                booleans[c - 'a'] = true;
            }
            counts[c - 'a']--;
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }
        return sb.reverse().toString();

    }
}
