package com.company.leetcode.editor.cn;//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
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



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.

 */
class TreeNode_98 {
    int val;
    TreeNode_98 left;
    TreeNode_98 right;
    TreeNode_98(int x) { val = x; }
}
class Solution_98 {
    public boolean isValidBST(TreeNode_98 root) {
        return helper(root.val,root.val,root.left,root,root.right);
    }

    private boolean helper(int min, int max, TreeNode_98 left, TreeNode_98 currentRoot, TreeNode_98 right) {
        if (currentRoot == null) {
            return false;
        }

        if (left.val > currentRoot.val) {
            return false;
        }

        if (right.val < currentRoot.val) {
            return false;
        }

        if (left.val < min) {
            return false;
        }

        if (right.val > max) {
            return false;
        }
        boolean res = helper(Integer.MIN_VALUE,max,left.left,left,left.right);
        if (!res){
            return false;
        }
        res = helper(min, Integer.MAX_VALUE,right.left,right,right.right);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
