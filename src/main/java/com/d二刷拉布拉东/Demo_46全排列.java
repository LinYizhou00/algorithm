package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 23:12
 */
public class Demo_46全排列 {
    public static void main(String[] args) {
        Demo_46全排列 demo = new Demo_46全排列();
        demo.permute(new int[]{1, 2, 3});
    }

    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, 0, nums.length);
        //System.out.println(result);
        return result;

    }

    public void backTrack(int[] nums, int start, int end) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < end; i++) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            backTrack(nums, start, end);
            path.removeLast();
        }
    }
}
