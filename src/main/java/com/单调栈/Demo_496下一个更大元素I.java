package com.单调栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/3/16 22:41
 */
public class Demo_496下一个更大元素I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Demo_496下一个更大元素I().nextGreaterElement(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2}
        )));
    }

    public int[] nextGreaterElement1(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() <= nums[i]) {
                deque.pop();
            }
            res[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(nums[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> res = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() <= nums2[i]) {
                deque.pop();
            }
            res.put(nums2[i], deque.isEmpty() ? -1 : deque.peek());
            deque.push(nums2[i]);
        }
        int[] resNums = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            resNums[i] = res.get(nums1[i]);
        }
        return resNums;
    }
}
