package com.a练习测试;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/7 21:56
 */
public class Demo_进制转换 {
    public static void main(String[] args) {
        System.out.println(8 ^ 3);
        System.out.println("====================================");

        String s = "8264";
        int number1 = 0;
        for (int i = 0; i < s.length(); i++) {
            number1 = number1 * 10 + s.charAt(i) - '0';
            System.out.println(number1);
        }
        System.out.println("====================================");
        int num = Integer.parseInt(s);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(num);
            int pow = (int) (Math.pow(10, (s.length() - i - 1)));
            num = (num % ((s.charAt(i) - '0') * pow));
        }


    }
}
