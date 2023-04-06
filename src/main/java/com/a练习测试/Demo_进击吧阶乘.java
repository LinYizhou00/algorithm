package com.a练习测试;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 14:52
 */
public class Demo_进击吧阶乘 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Scanner sc = new Scanner(System.in);
    static BigInteger[] nums = new BigInteger[10002];

    public static void main(String[] args) throws IOException {
        int index = 4;
        nums[0] = BigInteger.valueOf(0L);
        nums[1] = BigInteger.valueOf(1L);
        nums[2] = BigInteger.valueOf(2L);
        nums[3] = BigInteger.valueOf(6L);

        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            if (i < 4) {
                System.out.println(nums[i]);
                continue;
            }
            if (nums[i]==null) {
                for (int j = index; j <= i; j++) {
                    nums[j] = nums[j - 1].multiply(BigInteger.valueOf(j));
                }
                System.out.println(nums[i]);
                index = i + 1;
            }
        }
    }
}
