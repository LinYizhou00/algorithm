package com.d二刷拉布拉东;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 19:50
 */
public class Demo_144二叉树的前序遍历 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;

    }
}
