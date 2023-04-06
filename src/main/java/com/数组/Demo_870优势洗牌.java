package com.数组;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/10 10:13
 */
public class Demo_870优势洗牌 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));

    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> pair2[1] - pair1[1]);
        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int[] res = new int[n], poll;
        int left = 0, right = nums1.length - 1, index, value;
        while (!maxpq.isEmpty()) {
            poll = maxpq.poll();
            index = poll[0];
            value = poll[1];
            if (value < nums1[right]) {
                res[index] = nums1[right--];
            } else {
                res[index] = nums1[left++];
            }
        }
        return res;
    }
}
