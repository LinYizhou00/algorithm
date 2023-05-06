package com.d二刷拉布拉东;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 23:41
 */
public class Demo_752打开转盘锁 {
    public static void main(String[] args) {

        System.out.println(new Demo_752打开转盘锁().openLock(new String[]{
                "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"
        }, "8888"));


    }

    public int openLock(String[] deadends, String target) {
        int count = 0;
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> traverse = new HashSet<>();
        if (deadSet.contains("0000")) return -1;
        traverse.add("0000");
        while (!traverse.isEmpty()) {
            if (traverse.contains(target)) return count;
            deadSet.addAll(traverse);
            Set<String> newSet = new HashSet<>();
            count++;
            for (String s : traverse) {
                for (int j = 0; j < 4; j++) {
                    String up = up(s, j);
                    String down = down(s, j);
                    if (!deadSet.contains(up)) newSet.add(up);
                    if (!deadSet.contains(down)) newSet.add(down);
                }
            }
            traverse = newSet;
        }
        return -1;
    }

    public String up(String target, int i) {
        char[] chars = target.toCharArray();
        chars[i] = chars[i] - '0' == 9 ? '0' : (char) (chars[i] + 1);
        return new String(chars);
    }

    public String down(String target, int i) {
        char[] chars = target.toCharArray();
        chars[i] = chars[i] - '0' == 0 ? '9' : (char) (chars[i] - 1);
        return new String(chars);

    }


}
