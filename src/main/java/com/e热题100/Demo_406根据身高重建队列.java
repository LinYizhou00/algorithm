package com.e热题100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/4 13:25
 */
public class Demo_406根据身高重建队列 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Demo_406根据身高重建队列().reconstructQueue(new int[][]{

                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        })));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            int index = person[1];
            if (index <= list.size()) {
                list.add(index, person);
            } else {
                list.add(person);
            }
        }
        return list.toArray(new int[people.length][2]);
    }
}
