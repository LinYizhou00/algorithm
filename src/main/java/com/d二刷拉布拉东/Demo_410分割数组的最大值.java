package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/5 15:49
 */
public class Demo_410分割数组的最大值 {
    public static void main(String[] args) {
        System.out.println(new Demo_410分割数组的最大值().splitArray(new int[]{
              1,2,3,4,5
        }, 2));
    }

    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int i = arrayToM(nums, mid);
            if (i == -1) {
                left = mid + 1;
                continue;
            }
            if (i < k) {
                right = mid - 1;
            } else if (i > k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left ;
    }

    public int arrayToM(int[] nums, int sum) {
        int w = sum;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (sum < num) {
                return -1;
            } else {
                if (w < num) {
                    w = sum;
                    count++;
                    i--;
                } else {
                    w -= num;
                    if (w == 0) {
                        count++;
                        w = sum;
                    }
                }
            }
        }
        if (w != sum) count++;
        return count;
    }
}
