package com.f剑指offer;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 20:13
 */
public class Demo_剑指Offer04二维数组中的查找 {
    public static void main(String[] args) {

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
