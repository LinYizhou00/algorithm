package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/30 22:00
 */
public class Demo_54螺旋矩阵 {
    public static void main(String[] args) {
        System.out.println(new Demo_54螺旋矩阵().spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int count = matrix[0].length * matrix.length;
        int left = 0, top = 0, right = matrix[0].length - 1,
                bottom = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                count--;
            }
            if (count <= 0) break;
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
                count--;
            }
            if (count <= 0) break;
            right--;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
                count--;
            }
            if (count <= 0) break;
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
                count--;
            }
            if (count <= 0) break;
            left++;


        }
        return res;

    }
}
