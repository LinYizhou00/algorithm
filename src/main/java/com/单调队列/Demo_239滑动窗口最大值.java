package com.单调队列;

import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/7 0:47
 */
class MioQueue {
    LinkedList<Integer> queue = new LinkedList<Integer>();

    int getMax() {
        return queue.peek();
    }

    void remove(int n) {
        if (queue.peek() == n) {
            queue.poll();
        }
    }

    void add(int n) {
        while (!queue.isEmpty() && queue.peekLast() < n) {
            queue.pollLast();
        }
        queue.offerLast(n);

    }

}

public class Demo_239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] list = new int[nums.length - k + 1];
        int index = 0;

        MioQueue queue = new MioQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.add(nums[i]);
            } else {
                queue.add(nums[i]);
                list[index++] = queue.getMax();
                queue.remove(nums[i - k + 1]);
            }
        }
        return list;

    }
}
