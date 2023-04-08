package com.e热题100;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/15 1:29
 */
public class Demo_49字母异位词分组 {
    public static void main(String[] args) {
        groupAnagrams(new String[]{""});

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            String s = strsToNum(str);
            ArrayList<String> strings1 = new ArrayList<>();
            strings1.add(str);
            map.merge(s, strings1, (strings, strings2) -> {
                strings.addAll(strings2);
                return strings;
            });
        }
        ArrayList<List<String>> lists = new ArrayList<>(map.values());
        System.out.println(lists);
        return lists;


    }

    public static String strsToNum(String strs) {

        char[] chars = strs.toCharArray();
        Arrays.sort(chars);
        return new String(chars);


    }

}
