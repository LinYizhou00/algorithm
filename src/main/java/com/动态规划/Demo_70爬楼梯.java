package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/20 13:32
 */
public class Demo_70爬楼梯 {
    public static void main(String[] args) {
        System.out.println(new Demo_70爬楼梯().climbStairs(4));

    }

    public int climbStairs(int n) {

        int left = 1;
        int right = 2;
        if (n == 1) return left;
        if (n == 2) return right;
        int swap;
        for (int i = 2; i < n; i++) {
            swap = left + right;
            left = right;
            right = swap;
        }
        return right;

    }
}
