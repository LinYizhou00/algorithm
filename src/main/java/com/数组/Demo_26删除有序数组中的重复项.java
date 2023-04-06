package com.数组;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 10:33
 */
public class Demo_26删除有序数组中的重复项 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{2, 2, 2, 2, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast<nums.length){
            if (nums[fast]!=nums[slow]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
