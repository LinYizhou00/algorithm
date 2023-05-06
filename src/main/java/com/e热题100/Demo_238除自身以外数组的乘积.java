package com.e热题100;

import java.util.Arrays;

/**
 * @Author Lin Yizhou
 * @Date 2023/5/4 16:50
 */
public class Demo_238除自身以外数组的乘积 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Demo_238除自身以外数组的乘积().productExceptSelf(new int[]{
                1, 2, 3, 4
        })));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}
