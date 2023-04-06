package com.二维数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 13:15
 */
public class Demo_54螺旋矩阵 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0, left = 0, down = matrix.length - 1, right = matrix[0].length - 1;
        int n = matrix.length * matrix[0].length;
        while (list.size() < n) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if (list.size() == n) break;
            for (int i = top; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (list.size() == n) break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);

            }
            down--;
            if (list.size() == n) break;
            for (int i = down; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }

}
