package com.f剑指offer;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/6 19:48
 */
public class Demo_剑指Offer03数组中重复的数字 {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i!=nums[i]) {
                if (nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                int a=nums[nums[i]] ;
                nums[nums[i]]=nums[i];
                nums[i]=a;
            }
        }
        return 0;
    }
}
