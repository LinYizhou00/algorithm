package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 14:41
 */
public class Demo_167两数之和II输入有序数组 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int last = numbers.length - 1;
        int first = 0;
        while (first < last) {
            int i = numbers[first] + numbers[last];
            if (i > target) {
                last--;
            } else if (i < target) {
                first++;
            } else {
                break;
            }
        }
        return new int[]{first + 1, 1 + last};
    }
}
