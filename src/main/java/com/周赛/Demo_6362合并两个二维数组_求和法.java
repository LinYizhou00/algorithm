package com.周赛;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 10:36
 */
public class Demo_6362合并两个二维数组_求和法 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}})));
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] res = new int[nums1.length + nums2.length][2];
        int index = 0;
        int one = 0;
        int two = 0;
        while (one < nums1.length && two < nums2.length) {

            int[] n1 = nums1[one];
            int[] n2 = nums2[two];

            if (n1[0] == n2[0]) {
                res[index++] = new int[]{n1[0], n1[1] + n2[1]};
                one++;
                two++;
            } else if (n1[0] > n2[0]) {
                res[index++] = new int[]{n2[0], n2[1]};
                two++;
            } else {
                res[index++] = new int[]{n1[0], n1[1]};
                one++;
            }
        }
        while (one < nums1.length) {
            int[] n1 = nums1[one];

            res[index++] = new int[]{n1[0], n1[1]};
            one++;
        }
        while (two < nums2.length) {

            int[] n2 = nums2[two];
            res[index++] = new int[]{n2[0], n2[1]};
            two++;
        }
        return Arrays.copyOf(res, index);

    }
}
