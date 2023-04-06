package com.数组;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/10 22:50
 */
public class Demo_380O1时间插入_删除和获取随机元素 {
    int[] nums;
    Map<Integer, Integer> map;
    int index;
    Random random;


    public Demo_380O1时间插入_删除和获取随机元素() {
        nums = new int[(int) 2e5];
        map = new HashMap<>();
        index = 0;
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, index);
        nums[index++] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Integer remove = map.remove(val);
        if (remove != index-- - 1) map.put(nums[remove] = nums[index], remove);
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(index)];
    }
}