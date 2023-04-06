package com.二维数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 13:30
 */
public class Demo_59螺旋矩阵II {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);

        for (int[] n : ints
        ) {
            System.out.println(Arrays.toString(n));
        }

    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int top = 0, left = 0, down = n - 1, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int j = left; j <= right; j++) nums[top][j] = num++;
            top++;
            for (int j = top; j <= down; j++) nums[j][right] = num++;
            right--;
            for (int j = right; j >= left; j--) nums[down][j] = num++;
            down--;
            for (int j = down; j >= top; j--) nums[j][left] = num++;
            left++;
        }
        return nums;
    }
}
