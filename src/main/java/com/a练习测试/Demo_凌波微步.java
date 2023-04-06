package com.a练习测试;

import java.io.*;
import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 14:38
 */
public class Demo_凌波微步 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int count = 0;
            int[] nums = new int[Integer.parseInt(br.readLine())];
            if (nums.length < 2) {
                bw.write(nums.length + "\n");
                continue;
            }
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(nums, 1, nums.length);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    count++;
                }
            }
            bw.write((count + 1) + "\n");
        }
        bw.flush();
    }

}
