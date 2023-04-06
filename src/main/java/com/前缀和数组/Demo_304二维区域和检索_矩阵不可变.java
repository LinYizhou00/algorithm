package com.前缀和数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/6 21:05
 */
public class Demo_304二维区域和检索_矩阵不可变 {
    static int[][] shuSums;


    public static void main(String[] args) {

        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        Demo_304二维区域和检索_矩阵不可变 demo = new Demo_304二维区域和检索_矩阵不可变(matrix);
        System.out.println(sumRegion(2, 1, 4, 3));

    }

    public Demo_304二维区域和检索_矩阵不可变(int[][] matrix) {
        shuSums = new int[matrix.length + 1][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                shuSums[j + 1][i] = matrix[j][i] + shuSums[j][i];
            }
        }
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        int sum =0 ;

        for (int i = col1; i <= col2; i++) {
            sum += shuSums[row2 + 1][i] - shuSums[row1][i];
        }

        return sum;
    }
}
