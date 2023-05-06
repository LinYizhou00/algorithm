package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 21:43
 */
public class Demo_304二维区域和检索矩阵不可变 {
    public static void main(String[] args) {
        System.out.println(new Demo_304二维区域和检索矩阵不可变(new int[][]{
                {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
        }).sumRegion(
                2, 1, 4, 3
        ));
    }

    int[][] proSum;

    public Demo_304二维区域和检索矩阵不可变(int[][] matrix) {
        proSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                proSum[i][j + 1] = proSum[i][j] + matrix[i][j];
            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int count = 0;
        for (int i = row1; i <= row2; i++) {
            count += proSum[i][col2 + 1] - proSum[i][col1];

        }
        return count;

    }
}
