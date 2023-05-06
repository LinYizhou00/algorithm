package com.d二刷拉布拉东;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/5 16:28
 */
public class Demo_870优势洗牌 {
    public static void main(String[] args) {

    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums2.length; i++) {
            priorityQueue.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        int index = nums1.length - 1;
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if (poll[1] < nums1[index]) {
                res[poll[0]] = nums1[index--];
            } else {
                res[poll[0]] = nums1[i++];
            }
        }
        return res;

    }
}
