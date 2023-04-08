package com.f剑指offer;

import java.util.Stack;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 21:47
 */
public class Demo_剑指Offer30包含min函数的栈 {
    public static void main(String[] args) {

    }

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Demo_剑指Offer30包含min函数的栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(minStack.isEmpty() ? x : Math.min(minStack.peek(), x));

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();

    }
}
