package com.a练习测试;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/10 12:26
 */
public class Demo_新特性 {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 5, 3, 4, 5};
        List<Integer> collect = Arrays.stream(nums).collect(Collectors.toList());
        System.out.println("========================================");
        Arrays.stream(nums).filter(a -> a > 4).forEach(System.out::print);

        System.out.println(Arrays.toString(nums));
        System.out.println(collect);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("adfv");
        arrayList.add("avasdf");
        String s = String.join(",", arrayList);
        System.out.println(s);

        String[] strs = {"1", "2", "3"};
        String collect1 = String.join(".", strs);
        System.out.println(collect1);

        System.out.println("========================================");

        Random random = new Random();
        Stream<Integer> generateRandom = Stream.generate(random::nextInt);
        List<Integer> numberList = generateRandom.limit(1000).collect(Collectors.toList());

        int sum = numberList.parallelStream()
                .map(number -> number * 2)
                .mapToInt(x -> x)
                .sum();
        System.out.println(sum);
        System.out.println("========================================");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("========================================");
        System.out.println(LocalDate.of(2022, 1, 1));
        System.out.println(LocalTime.of(12, 1, 1, 1));
        System.out.println(LocalDateTime.of(2022, 2, 2, 12, 3, 30));
        System.out.println("========================================");
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDate.parse("2020+12+22", DateTimeFormatter.ofPattern("yyyy+MM+dd")));
        System.out.println("========================================");

        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy+MM+dd")));
        System.out.println("========================================");
        LocalDate date = LocalDate.of(2022, 1, 1);
        System.out.println(localDate.until(date, ChronoUnit.DAYS));
        System.out.println(localDate.plusDays(20));
        System.out.println(Year.isLeap(2020));
        System.out.println(Year.now().until(Year.of(2020), ChronoUnit.YEARS));
        System.out.println("========================================");
        System.out.println(LocalDate.now().plusDays(2000));

        System.out.println(2e5 * 4 / 1024 / 1024);
        System.out.println("========================================");
        Arrays.stream(new int[]{1, 2, 3}).forEach(value -> {
            if (value == 2) return;
            System.out.println(value);
        });
        System.out.println("========================================");
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> value = new ArrayList<>();
        value.add("sdafs");
        map.put(1, value);
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        map.merge(1, list, (strings, strings2) -> {
            strings.addAll(strings2);
            return strings;
        });
        System.out.println(map);

    }
}
