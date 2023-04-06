package com.二叉树;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/18 18:59
 */
public class Demo_96不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }


    static Map<Integer, Integer> hashMap = new HashMap<>();

    public static int numTrees(int n) {
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        int res = 0;
        if (n == 0 || n == 1) return 1;
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            res += left * right;
        }
        hashMap.put(n, res);
        return res;
    }


}
