package com.二叉树;

import java.util.HashMap;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/12 23:07
 */
public class Demo_剑指Offer07重建二叉树 {
    public static void main(String[] args) {

    }

    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int index = hashMap.get(treeNode.val);
        int lSize = index - 1 - inStart;
        treeNode.left = build(preorder, preStart + 1, preStart + 1 + lSize, inorder, inStart, index - 1);
        treeNode.right = build(preorder, preStart + 1 + lSize + 1, preEnd, inorder, index + 1, inEnd);
        return treeNode;
    }
}
