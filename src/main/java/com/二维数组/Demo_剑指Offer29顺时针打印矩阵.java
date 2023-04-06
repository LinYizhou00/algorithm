package com.二维数组;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 13:51
 */
public class Demo_剑指Offer29顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int n = matrix.length * matrix[0].length;
        int[] nums = new int[n];
        int index = 0;

        int top = 0, left = 0, down = matrix.length - 1, right = matrix[0].length - 1;

        while (index < n) {
            for (int i = left; i <= right; i++) {
                nums[index++] = matrix[top][i];
            }
            top++;
            if (index == n) break;
            for (int i = top; i <= down; i++) {
                nums[index++] = matrix[i][right];
            }
            right--;
            if (index == n) break;
            for (int i = right; i >= left; i--) {
                nums[index++] = matrix[down][i];

            }
            down--;
            if (index == n) break;
            for (int i = down; i >= top; i--) {
                nums[index++] = matrix[i][left];
            }
            left++;
        }
        return nums;
    }
}
