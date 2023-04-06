package com.缓存淘汰算法;

import java.util.LinkedHashMap;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/26 21:55
 */
public class Demo_剑指Offer_II_031最近最少使用缓存 {
    public static void main(String[] args) {

    }
// 使用api实现
// 其他看 Demo_146LRU缓存.java


    int cap;
    LinkedHashMap<Integer, Integer> cache;

    public Demo_剑指Offer_II_031最近最少使用缓存(int capacity) {
        this.cap = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>();

    }

    public int makeRU(int key) {
        Integer value = cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        return makeRU(key);


    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRU(key);
            return;
        }
        if (cap == cache.size()) {
            Integer firstKey = cache.keySet().iterator().next();
            cache.remove(firstKey);
        }
        cache.put(key, value);

    }
}
