package com.ljg.leetcode.week02.a_01.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

/**
 * ConstructBinaryTree
 */
public class ConstructBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int preIndex = 0;
    private int[] preOrder;
    private int[] inOrder;
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    private TreeNode build(int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return null;
        }

        int value = preOrder[preIndex];
        TreeNode treeNode = new TreeNode(value);
        preIndex++;

        int index = map.get(value);

        treeNode.left = build(leftIndex, index);

        treeNode.right = build(index + 1, rightIndex);

        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preOrder = preorder;
        this.inOrder = inorder;

        int index = 0;
        for (int value : inorder) {
            map.put(value, index++);
        }

        return build(0, inorder.length);
    }

    public static void main(String[] args) {

        int[] preorder = new int[] { 3, 9, 20, 15, 7 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };

        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode treeNode = constructBinaryTree.buildTree(preorder, inorder);
        System.out.println(treeNode);

    }
}