package com.f剑指offer;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 20:41
 */
public class Demo_剑指Offer50第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }

    public static char firstUniqChar(String s) {
        byte[] ints = new byte[26];
        for (int i = 0; i < s.length(); i++) {
            if (ints[s.charAt(i) - 'a']>2){
                continue;
            }
            ints[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (ints[s.charAt(i)-'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
