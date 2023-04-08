package com.f剑指offer;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 23:06
 */
class MioQueue{
    LinkedList<Integer> queue =  new LinkedList<Integer>();
    int getMax(){
        return queue.peek();
    }
    void remove(int n){
        if (queue.peek() == n){
            queue.poll();
        }
    }
    void add(int n ){
        while (!queue.isEmpty()&&queue.peekLast()<n){
            queue.pollLast();
        }
        queue.offerLast(n);

    }

}
public class Demo_剑指Offer59_I_滑动窗口的最大值 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] list = new int[nums.length - k + 1];
        int index = 0;

        MioQueue queue = new MioQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k-1) {
                queue.add(nums[i]);
            }else {
                queue.add(nums[i]);
                list[ index++] = queue.getMax();
                queue.remove(nums[i-k+1]);

            }

        }


        return list;

    }
}
