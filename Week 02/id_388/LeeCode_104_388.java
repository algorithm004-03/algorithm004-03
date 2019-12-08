package com.company.leetcode.editor.cn;//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode_104 {
    int val;
    TreeNode_104 left;
    TreeNode_104 right;
    TreeNode_104(int x) { val = x; }
}
class Solution_104 {
    public int maxDepth(TreeNode_104 root) {
        return helper(root,0);
    }

    private int helper(TreeNode_104 root, int depth) {
        if (root == null) { return depth; }
        depth++;
        return Math.max(helper(root.left,depth),helper(root.right,depth));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
