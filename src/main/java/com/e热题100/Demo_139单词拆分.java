package com.e热题100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/16 20:01
 */
public class Demo_139单词拆分 {
    public static void main(String[] args) {
        System.out.println(new Demo_139单词拆分().wordBreak("leetcode", Arrays.asList("leet", "code")));

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String s1 = wordDict.get(j);
                int length = s1.length();
                if (i >= length && s1.equals(s.substring(i - length, i)) && dp[i - length]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
