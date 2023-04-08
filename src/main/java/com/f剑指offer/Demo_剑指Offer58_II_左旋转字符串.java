package com.f剑指offer;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/7 9:57
 */
public class Demo_剑指Offer58_II_左旋转字符串 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("lrloseumgh", 6));
    }

    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverseChars(chars, 0, n-1);
        reverseChars(chars, n, chars.length-1);
        reverseChars(chars, 0, chars.length-1);
        return  new String(chars) ;
    }

    public static void reverseChars(char[] chars, int start, int end) {
        char temp;
        int left = start;
        int right = end;
        while (left < right) {
            temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}
