package com.e热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/4 13:35
 */
public class Demo_287寻找重复数 {
    public static void main(String[] args) {
        System.out.println(new Demo_287寻找重复数().findDuplicate(new int[]{
                1, 3, 4, 2, 2
        }));
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
