package com.f剑指offer;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/17 11:42
 */
public class Demo_剑指Offer11旋转数组的最小数字 {
    public static void main(String[] args) {

    }

    public int minArray(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();

    }
}
