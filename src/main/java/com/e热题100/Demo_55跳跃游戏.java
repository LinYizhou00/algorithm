package com.e热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/16 8:39
 */
public class Demo_55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int lift = 1, index = 0;
        while (lift > 0) {
            if (index == nums.length - 1) return true;
            lift = Math.max(nums[index++], --lift);
        }
        return false;

    }
}
