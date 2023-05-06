package com.e热题100;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/4 17:20
 */
public class Demo_347前K个高频元素 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Demo_347前K个高频元素().topKFrequent(new int[]{
                1, 1, 1, 2, 2, 3
        }, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        hashMap.entrySet().forEach(queue::offer);
        for (int i = 0; i < k; i++) {
            nums[i] = queue.poll().getKey();
        }
        return Arrays.copyOf(nums, k);

    }
}
