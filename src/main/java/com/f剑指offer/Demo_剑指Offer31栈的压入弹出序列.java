package com.f剑指offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 22:00
 */
public class Demo_剑指Offer31栈的压入弹出序列 {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new LinkedList<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            deque.push(pushed[i]);
            while (!deque.isEmpty() && deque.peek() == popped[popIndex]) {
                deque.pop();
                popIndex++;
            }
        }
        return deque.isEmpty();
    }
}
