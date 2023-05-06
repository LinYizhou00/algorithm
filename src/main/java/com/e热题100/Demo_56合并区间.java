package com.e热题100;

import com.d二刷拉布拉东.Demo_567字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/16 8:44
 */
public class Demo_56合并区间 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Demo_56合并区间().merge(
                new int[][]{
                        {1, 3}

                }
        )));

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return new int[][]{{intervals[0][0], intervals[0][1]}};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (right >= interval[0]) {
                right = Math.max(right, interval[1]);
            } else {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
            if (i == intervals.length - 1) {
                list.add(new int[]{left, right});
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
