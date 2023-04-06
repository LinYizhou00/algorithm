package com.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/11 1:26
 */
public class Demo_710黑名单中的随机数 {

    Random rand;
    int max;
    int index;
    TreeSet<Integer> set;
    HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) {
        int[] ints = {0, 2};
        Demo_710黑名单中的随机数 demo = new Demo_710黑名单中的随机数(4, ints);
        for (int i = 0; i < 100; i++) {
            System.out.println(demo.pick());
        }


    }

    public Demo_710黑名单中的随机数(int n, int[] blacklist) {

        set = new TreeSet<>();
        for (int j : blacklist) {
            set.add(j);
        }
        max = n - blacklist.length;
        index = max;
        hashMap = new HashMap<>();

        for (Integer i : set) {
            if (i < max) {
                while (set.contains(index)) {
                    index++;
                }
                hashMap.put(i, index++);
            } else {
                break;
            }
        }
        rand = new Random();
    }

    public int pick() {
        int i = rand.nextInt(max);
        if (!set.contains(i)) return i;
        else return hashMap.get(i);
    }
}
