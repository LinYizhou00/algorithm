package com.动态规划;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/27 23:14
 */
public class Demo_剑指Offer10_II_青蛙跳台阶问题 {
    public static void main(String[] args) {
        Demo_剑指Offer10_II_青蛙跳台阶问题 demo = new Demo_剑指Offer10_II_青蛙跳台阶问题();
        System.out.println(demo.numWays(44));
    }

    public int numWays(int n) {
        int[] nums = {1, 1, 2};
        if (n < 3) return nums[n];
        for (int i = 2; i < n; i++) {
            nums[0] = nums[1];
            nums[1] = nums[2];
            nums[2] = (int) ((nums[0] + nums[1]) % (1e9 + 7));
        }

        return nums[2];
    }
}
