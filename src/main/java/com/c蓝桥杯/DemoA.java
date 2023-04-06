package com.c蓝桥杯;

import java.time.LocalDate;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 10:43
 */
public class DemoA {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(1900, 1, 1);
        LocalDate end = LocalDate.of(9999, 12, 31);
        int count = 0;
        while (!start.isAfter(end)) {
            if (isCheck(start)) {
                System.out.println(start);
                count++;
            }
            start = start.plusDays(1);

        }
        System.out.println(count);
    }

    public static boolean isCheck(LocalDate time) {
        String s = String.valueOf(time.getYear());
        int year = 0;
        for (int i = 0; i < s.length(); i++) {
            year += s.charAt(i) - '0';
        }
        int month = 0;
        String ss = String.valueOf(time.getMonthValue());
        for (int i = 0; i < ss.length(); i++) {
            month += ss.charAt(i) - '0';
        }
        String sss = String.valueOf(time.getDayOfMonth());
        for (int i = 0; i < sss.length(); i++) {
            month += sss.charAt(i) - '0';
        }
        return year == month;

    }
}
