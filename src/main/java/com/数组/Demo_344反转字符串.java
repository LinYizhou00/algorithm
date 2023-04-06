package com.数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 14:46
 */
public class Demo_344反转字符串 {
    public static void main(String[] args) {

    }

    public static void reverseString(char[] s) {

        int top = 0, last = s.length - 1;
        char swap;
        while (top < last) {
            swap = s[top];
            s[top++] = s[last];
            s[last--] = swap;
        }

    }
}
