package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/31 11:22
 */
public class Demo_509斐波那契数 {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        int[] num = new int[2];
        if (n<2)return n;
        num[1]=1;
        for (int i = 0; i < n; i++) {
            int sum = num[0] + num[1];
            num[0]=num[1];
            num[1]=sum;
        }
        return num[0];
    }
}
