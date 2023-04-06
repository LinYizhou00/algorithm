package com.周赛;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/18 22:28
 */
public class Demo_6359替换一个数字后的最大差值 {
    public static void main(String[] args) {
        System.out.println(minMaxDifference(99999));
    }

    public static int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int min = Integer.parseInt(s.replace(s.charAt(0), '0'));
        int max = num;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                max = Integer.parseInt(s.replace(s.charAt(i), '9'));
                break;
            }
        }
        return max - min;


    }
}
