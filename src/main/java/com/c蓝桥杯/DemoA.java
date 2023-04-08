package com.c蓝桥杯;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 10:43
 */
public class DemoA {
    public static void main(String[] args) {

        System.out.println(123);
        System.out.println(Integer.toHexString(15));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.parseInt("10010", 2));
        System.out.println(Integer.toString(15, 3));
        ArrayList<Integer> list = new ArrayList<>( Arrays.asList(1,2,3));
        Object clone2 = list.clone();
        list.remove(0);
        System.out.println(list);
        System.out.println(clone2);
        int[] nums = {1, 2, 3};
        Integer[] integers = {1, 2, 3};
        int[] clone = nums.clone();

        System.out.println("==========================");
        //System.out.println(Arrays.toString(clone));
        //System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(integers));

        Integer[] clone1 = integers.clone();
        System.out.println(Arrays.toString(clone1));
        nums[1] = 9;
        integers[1] = 12;
        //System.out.println(Arrays.toString(clone));
        //System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(clone1));
        System.out.println(String.join("+", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

        System.out.println(1 / 2.0 * 1);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(LocalDate.parse("2000-10-01",pattern));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());
        System.out.println(String.format("%03d", 12));

    }
}
