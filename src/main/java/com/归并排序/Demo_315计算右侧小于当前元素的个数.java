package com.归并排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/14 9:34
 */
class Pair {
    int val;
    int index;

    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

public class Demo_315计算右侧小于当前元素的个数 {

    public static void main(String[] args) {
        int[] ints = {1, 1};
        System.out.println(countSmaller(ints));
    }

    public static List<Integer> countSmaller(int[] nums) {
        if (nums == null) return new ArrayList<>();
        swap = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        sort(pairs, 0, nums.length - 1);
        List<Integer> list = new ArrayList<>();
        Arrays.stream(count).forEach(list::add);
        return list;

    }

    static Pair[] swap;
    static int[] count;

    public static void sort(Pair[] nums, int start, int end) {
        if (start == end) return;
        int mid = start + ((end - start) >> 1);
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(Pair[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            swap[i] = nums[i];
        }
        int first = start;
        int second = mid + 1;
        int index = start;
        for (int i = start; i <= end; i++) {
            if (first == mid + 1) {
                nums[index++] = swap[second++];
            } else if (second == end + 1) {
                nums[index++] = swap[first++];
                count[nums[index - 1].index] += second - mid - 1;
            } else if (swap[first].val <= swap[second].val) {
                nums[index++] = swap[first++];
                count[nums[index - 1].index] += second - mid - 1;
            } else {
                nums[index++] = swap[second++];
            }
        }


    }

}
