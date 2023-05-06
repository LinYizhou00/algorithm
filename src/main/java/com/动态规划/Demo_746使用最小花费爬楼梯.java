package com.动态规划;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/20 12:37
 */
public class Demo_746使用最小花费爬楼梯 {
    public static void main(String[] args) {
        System.out.println(new Demo_746使用最小花费爬楼梯().minCostClimbingStairs(
                new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        ));
    }

    public int minCostClimbingStairs(int[] cost) {

        int left = 0;
        int right = 0;
        int swap;
        for (int i = 2; i < cost.length + 1; i++) {
            swap = Math.min(right + cost[i - 1], left + cost[i - 2]);
            left = right;
            right = swap;
        }
        return right;

    }


}
