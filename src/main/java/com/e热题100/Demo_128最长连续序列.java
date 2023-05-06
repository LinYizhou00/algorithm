package com.e热题100;

import java.util.HashSet;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/16 9:18
 */


public class Demo_128最长连续序列 {
    public static void main(String[] args) {
        System.out.println(new Demo_128最长连续序列().longestConsecutive(
                new int[]{100, 4, 200, 1, 3, 2}
        ));

    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int k : nums) {
            set.add(k);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int size = 1;
            while (set.contains(++num)) size++;
            result = Math.max(result, size);
        }
        return result;

    }
}
