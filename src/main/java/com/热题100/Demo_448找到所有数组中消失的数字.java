package com.热题100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/15 22:53
 */
public class Demo_448找到所有数组中消失的数字 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length + 1;
        int num;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            num = nums[i] % n;
            nums[num - 1] = nums[num - 1] + n;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < n) list.add(i + 1);
        }
        return list;
    }
}
