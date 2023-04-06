package com.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/11 13:26
 */
public class Demo_剑指Offer_II_030插入_删除和随机访问都是O1的容器 {
    int[] nums;
    Map<Integer, Integer> map;
    int index;
    Random random;


    public Demo_剑指Offer_II_030插入_删除和随机访问都是O1的容器() {
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
