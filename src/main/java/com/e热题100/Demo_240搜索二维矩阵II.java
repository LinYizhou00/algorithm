package com.e热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/4 19:36
 */
public class Demo_240搜索二维矩阵II {
    public static void main(String[] args) {
        System.out.println(new Demo_240搜索二维矩阵II().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        }, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {

            if (matrix[x][y] < target) {
                x++;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                return true;
            }

        }
        return false;

    }
}
