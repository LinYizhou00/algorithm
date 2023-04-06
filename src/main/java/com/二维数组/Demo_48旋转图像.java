package com.二维数组;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 13:59
 */
public class Demo_48旋转图像 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }


    }

    public static void res(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int swap;
        while (left < right) {
            swap = nums[left];
            nums[left++] = nums[right];
            nums[right--] = swap;
        }
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length == 0) return;
        int swap;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i < j) {
                    swap = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = swap;
                }
            }
        }
        for (int[] ints : matrix) {
            res(ints);
        }
    }
}
