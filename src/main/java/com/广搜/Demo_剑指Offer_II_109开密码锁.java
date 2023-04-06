package com.广搜;

import java.util.*;
import java.util.HashSet;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/2 19:55
 */
public class Demo_剑指Offer_II_109开密码锁 {
    public static void main(String[] args) {
        System.out.println(openLock(new String[]{
                "0201", "0101", "0102", "1212", "2002"
        }, "0202"));
    }

    public static int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains("0000")) {
            return -1;
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        int depth = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();

            for (String s : q1) {
                if (deads.contains(s)) {
                    continue;
                }
                if (q2.contains(s)) {
                    return depth;
                }
                visited.add(s);
                for (int j = 0; j < 4; j++) {
                    String upPoll = change(s, j, true);
                    String downPoll = change(s, j, false);
                    if (!visited.contains(upPoll)) {
                        temp.add(upPoll);
                    }
                    if (!visited.contains(downPoll)) {
                        temp.add(downPoll);
                    }
                }

            }
            depth++;
            q1 = q2;
            q2 = temp;

        }
        return -1;
    }

    public static String change(String poll, int i, boolean flag) {
        char[] chars = poll.toCharArray();
        chars[i] = flag ? (chars[i] == '9' ? '0' : (char) (chars[i] + 1)) : chars[i] == '0' ? '9' : (char) (chars[i] - 1);
        return new String(chars);
    }

}
