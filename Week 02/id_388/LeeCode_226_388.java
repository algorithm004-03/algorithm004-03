package com.company.leetcode.editor.cn;//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树



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
class TreeNode_226 {
    int val;
    TreeNode_226 left;
    TreeNode_226 right;
    TreeNode_226(int x) { val = x; }
}
class Solution_226 {
    public TreeNode_226 invertTree(TreeNode_226 root) {
        if (root == null) {
            return null;
        }
        helper(root,root.left,root.right);
        return root;
    }

    private void helper(TreeNode_226 root, TreeNode_226 left, TreeNode_226 right) {

        if (root == null) {
            return;
        }
        root.left = right;
        root.right = left;
        if (left != null) {
            helper(left,left.left,left.right);
        }
        if (right != null) {
            helper(right,right.left,right.right);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
