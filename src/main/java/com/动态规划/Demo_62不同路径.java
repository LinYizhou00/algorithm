package com.动态规划;


import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/20 13:41
 */
public class Demo_62不同路径 {
    public static void main(String[] args) {
        System.out.println(new Demo_62不同路径().uniquePaths(3, 7));
    }

    int[] memo;
    int len;

    public int uniquePaths(int m, int n) {

        len = n;
        memo = new int[m * n];
        Arrays.fill(memo, -1);
        return dp(m - 1, n - 1);

    }

    public int dp(int m, int n) {
        int nn = m * len + n;
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return 1;
        if (memo[nn] != -1) return memo[nn];
        int i = dp(m - 1, n) + dp(m, n - 1);
        memo[nn] = i;
        return i;

    }
}
