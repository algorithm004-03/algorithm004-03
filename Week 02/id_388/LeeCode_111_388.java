package com.company.leetcode.editor.cn;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索



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
class TreeNode_111 {
    int val;
    TreeNode_111 left;
    TreeNode_111 right;
    TreeNode_111(int x) { val = x; }
}
class Solution_111 {
    public int minDepth(TreeNode_111 root) {
        return helper(root,0);
    }

    //递归法
    private int helper(TreeNode_111 root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;

        if (root.left == null) {
            return helper(root.right,depth);
        }

        if (root.right == null) {
            return helper(root.left,depth);
        }

        return Math.min(helper(root.left,depth),helper(root.right,depth));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
