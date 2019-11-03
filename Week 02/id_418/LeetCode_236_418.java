package com.ljg.leetcode.week02.a_02.lowest_common_ancestor_of_a_binary_tree;

/**
 * Solution
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode commonAncestorNode;

    private boolean recursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        int left = recursive(root.left, p, q) ? 1 : 0;
        int right = recursive(root.right, p, q) ? 1 : 0;

        int mid = (root == p || root == q) ? 1 : 0;

        if ((left + right + mid) >= 2) {
            this.commonAncestorNode = root;
        }

        return (left + right + mid) > 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recursive(root, p, q);
        return this.commonAncestorNode;
    }
}