package com.e热题100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/16 10:08
 */


public class Demo_739每日温度 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Demo_739每日温度().dailyTemperatures(new int[]{
                73, 74, 75, 71, 69, 72, 76, 73
        })));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i]) {
                deque.pop();
            }
            res[i] = deque.isEmpty() ? 0 : deque.peek() - i;
            deque.push(i);
        }
        return res;

    }
}
