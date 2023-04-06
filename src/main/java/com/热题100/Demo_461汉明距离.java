package com.热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/15 23:22
 */
public class Demo_461汉明距离 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
