package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 17:40
 */
public class Demo_344反转字符串 {
    public static void main(String[] args) {
        Demo_344反转字符串 demo = new Demo_344反转字符串();



    } public void reverseString(char[] s) {
        int top = 0;
        int down  = s.length - 1;
        char swap ;
        while (top < down) {
            swap = s[down];
            s[down--] = s[top];
            s[top++] = swap;
        }

    }
}
