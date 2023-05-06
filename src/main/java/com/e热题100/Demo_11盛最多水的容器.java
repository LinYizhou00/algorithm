package com.e热题100;

import com.d二刷拉布拉东.Demo_111二叉树的最小深度;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/16 23:01
 */
public class Demo_11盛最多水的容器 {
    public static void main(String[] args) {
        System.out.println(new Demo_11盛最多水的容器().maxArea(new int[]{
                0,1,0,2,1,0,1,3,2,1,2,1
        }));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = -1;
        while (left < right) {
            int i = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, i);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;

    }
}
