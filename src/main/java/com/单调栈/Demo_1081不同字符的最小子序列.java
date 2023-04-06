package com.单调栈;
import java.util.*;
/**
 * @Author Lin Yizhou
 * @Date 2023/2/11 21:25
 */
public class Demo_1081不同字符的最小子序列 {
    public static void main(String[] args) {

    }
    public String smallestSubsequence(String s) {
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
