package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/30 22:48
 */
public class Demo_59螺旋矩阵II {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Demo_59螺旋矩阵II().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int index = 1;
        int[][] res = new int[n][n];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[top][i] = index++;
            }
            top++;
            if (index > n * n) break;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = index++;
            }
            right--;
            if (index > n * n) break;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = index++;
            }
            bottom--;
            if (index > n * n) break;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = index++;
            }
            left++;
            if (index > n * n) break;
        }
        return res;
    }
}
