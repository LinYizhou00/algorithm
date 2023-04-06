package com.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/12 21:09
 */
public class Demo_106从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);

        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);

    }

    public static TreeNode build(int[] inorder, int inStart, int inEnd,
                                 int[] postorder, int poStart, int poEnd) {
        if (inEnd < inStart) return null;
        TreeNode treeNode = new TreeNode(postorder[poEnd]);
        int index = map.get(treeNode.val);
        int size = index - inStart;
        treeNode.left = build(inorder, inStart, index - 1, postorder, poStart, poStart + size - 1);
        treeNode.right = build(inorder, index + 1, inEnd, postorder, poStart + size, poEnd - 1);
        return treeNode;

    }
}
