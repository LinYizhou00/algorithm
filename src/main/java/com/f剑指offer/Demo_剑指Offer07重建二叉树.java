package com.f剑指offer;


import java.util.HashMap;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/8 15:36
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Demo_剑指Offer07重建二叉树 {
    public static void main(String[] args) {
        Demo_剑指Offer07重建二叉树 demo = new Demo_剑指Offer07重建二叉树();

        TreeNode treeNode = demo.buildTree(new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7});

    }

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,  0 );

    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,   int inStart ) {
        if (preEnd < preStart) {
            return null;
        }
        TreeNode top = new TreeNode(preorder[preStart]);
        Integer index = hashMap.get(top.val);
        int size = index - inStart;
        top.left = build(preorder, preStart + 1, preStart + size,   inStart );
        top.right = build(preorder, preStart + 1 + size, preEnd,  index + 1 );

        return top;


    }

}
