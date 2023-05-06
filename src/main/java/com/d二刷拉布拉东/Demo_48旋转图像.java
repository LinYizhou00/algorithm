package com.d二刷拉布拉东;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/30 21:32
 */
public class Demo_48旋转图像 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        new Demo_48旋转图像().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        int i = matrix[0].length - 1;
        int index = 0;
        int swap;
        while (i > 0) {
            int ii = i;

            for (int j = 0; j < ii; j++) {
                swap = matrix[index][j];
                matrix[index][j] = matrix[matrix.length - 1 - j][matrix[0].length - 1 - index];
                matrix[matrix.length - 1 - j][matrix[0].length - 1 - index] = swap;
            }
            i--;
            index++;
        }

        for (int j = 0; j < matrix[0].length; j++) {

            int top = 0;
            int bottom = matrix.length - 1;
            while (top < bottom) {
                swap = matrix[top][j];
                matrix[top++][j] = matrix[bottom][j];
                matrix[bottom--][j] = swap;
            }

        }


    }
}
