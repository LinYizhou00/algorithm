package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/30 22:59
 */
public class Demo_187重复的DNA序列 {
    public static void main(String[] args) {
        System.out.println(new Demo_187重复的DNA序列().findRepeatedDnaSequences(
                "AAGATCCGTCCCCCCAAGATCCGTC"
        ));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        char[] chars = s.toCharArray();
        HashSet<Long> set = new HashSet<>();
        HashSet<Long> res = new HashSet<>();
        int left = 0;
        int right = 0;
        long num = 0;
        while (right < s.length()) {
            num = add(num, chars[right]);
            if (right - left == 9) {
                if (set.contains(num)) {
                    res.add(num);
                } else {
                    set.add(num);
                }
                left++;
                num = redu(num);
            }
            right++;
        }
        ArrayList<String> result = new ArrayList<>();
        for (Long aLong : res) {
            StringBuilder sb = new StringBuilder();
            String value = String.valueOf(aLong);

            for (int i = 0; i < value.length(); i++) {

                char c1 = value.charAt(i);
                if (c1 == '1') c1 = 'A';
                else if (c1 == '2') c1 = 'C';
                else if (c1 == '3') c1 = 'G';
                else c1 = 'T';
                sb.append(c1);
            }
            result.add(sb.toString());
        }
        return result;
    }

    public long redu(long num) {
        return num % (int) 1e9;
    }

    public long add(long num, char c) {
        int i;
        if (c == 'A') i = 1;
        else if (c == 'C') i = 2;
        else if (c == 'G') i = 3;
        else i = 4;
        return 10 * num + i;
    }
}
