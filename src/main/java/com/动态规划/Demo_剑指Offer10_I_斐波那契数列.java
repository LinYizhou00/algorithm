package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/28 13:24
 */
public class Demo_剑指Offer10_I_斐波那契数列 {
    public static void main(String[] args) {
        Demo_剑指Offer10_I_斐波那契数列 demo = new Demo_剑指Offer10_I_斐波那契数列();
        System.out.println(demo.fib(6));


    }

    public int fib(int n) {
        int[] nums = {0, 1};
        if (n < 2) return nums[n];
        int swap;
        for (int i = 1; i < n; i++) {
            swap = (int) (nums[1] % (1e9 + 7));
            nums[1] = (int) ((nums[0] + nums[1]) % (1e9 + 7));
            nums[0] = (int) (swap % (1e9 + 7));
        }
        return nums[1];
    }
}
