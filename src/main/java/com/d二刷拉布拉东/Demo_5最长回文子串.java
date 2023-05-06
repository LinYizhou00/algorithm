package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 18:56
 */
public class Demo_5最长回文子串 {
    public static void main(String[] args) {
        Demo_5最长回文子串 demo = new Demo_5最长回文子串();
        System.out.println(demo.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        String answer = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String check = check(s, i, i);
            String check1 = check(s, i, i + 1);
            String max = check.length() > check1.length() ? check : check1;
            answer = answer.length() > max.length() ? answer : max;

        }
        String check = check(s, s.length() - 1, s.length() - 1);
        answer = answer.length() > check.length() ? answer : check;
        return answer;

    }

    public String check(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start+1, end);

    }

}
