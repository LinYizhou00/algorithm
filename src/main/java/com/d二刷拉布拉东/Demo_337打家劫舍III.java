package com.d二刷拉布拉东;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/14 15:05
 */
public class Demo_337打家劫舍III {
    public static void main(String[] args) {
        Demo_337打家劫舍III demo = new Demo_337打家劫舍III();
        System.out.println(demo.rob(new TreeNode()));
    }

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int do_it = root.val + ((root.left == null) ? 0 : rob(root.left.left) + rob(root.left.right))
                + ((root.right == null) ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_do_it =
                rob(root.left) + rob(root.right);
        memo.put(root, Math.max(do_it, not_do_it));
        return Math.max(do_it, not_do_it);

    }


}
