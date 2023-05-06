package com.d二刷拉布拉东;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/14 22:53
 */
public class Demo_1两数之和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Demo_1两数之和().twoSum(new int[]{
                2, 7, 11, 15
        }, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                int b = map.get(n);

                return new int[]{i, b};
            }
            map.put(nums[i], i);
        }
        return null;


    }
}
