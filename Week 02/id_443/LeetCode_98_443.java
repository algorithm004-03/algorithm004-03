//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索

package com.modds.alltest.leetcode.editor.cn;

public class LeetCode_98_443_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LeetCode_98_443_ValidateBinarySearchTree().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        public boolean isValidBST(TreeNode node, Integer min, Integer max) {
            if (node == null) return true;
            if (node.left != null) {
                if (node.left.val >= node.val || (min != null && node.left.val <= min)) {
                    return false;
                }
            }
            if (node.right != null) {
                if (node.right.val <= node.val || (max != null && node.right.val >= max)) {
                    return false;
                }
            }
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}