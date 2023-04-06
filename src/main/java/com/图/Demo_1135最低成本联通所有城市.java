package com.图;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/24 19:19
 */
public class Demo_1135最低成本联通所有城市 {
    public static void main(String[] args) {
        Demo_1135最低成本联通所有城市 demo = new Demo_1135最低成本联通所有城市();
        System.out.println(demo.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
    }

    public int minimumCost(int n, int[][] connections) {
        NewUF uf = new NewUF(n + 1);
        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));
        int len = 0;
        for (int[] value : connections) {
            if (!uf.isConnect(value[0], value[1])) {
                uf.union(value[0], value[1]);
                len += value[2];
            }
        }
        return uf.getCount() == 2 ? len : -1;
    }

}
