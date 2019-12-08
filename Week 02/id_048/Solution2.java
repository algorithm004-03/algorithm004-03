package com.leetcode.week02;

/**
 * Created by tim on 2019/10/27.
 */
public class Solution2 {
    private TreeNode ans;

    public Solution2() {
        // Variable to store LCA node.变量保存在LCA节点
        this.ans = null;
    }

    //https://leetcode-cn.com/problems/permutations/
    //236. 二叉树的最近公共祖先

    /**
     * 是否递归树
     * @param currentNode
     * @param p
     * @param q
     * @return
     */
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
// Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
