package com.f剑指offer;

import java.util.Stack;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 21:16
 */
public class Demo_剑指Offer09用两个栈实现队列 {
    Stack<Integer> in;
    Stack<Integer> out;


    public Demo_剑指Offer09用两个栈实现队列() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void appendTail(int value) {
        in.push(value);

    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.isEmpty() ? -1 : out.pop();
    }
}
