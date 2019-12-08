/*
 * @lc app=leetcode.cn id=236 lang=javascript
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    let result = null;
    function lowestCommon(root, p, q) {
        if (root == null) {
            return false;
        }
        let left = lowestCommon(root.left, p, q) ? 1 : 0;
        let right = lowestCommon(root.right, p, q) ? 1 : 0;
        let mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            result = root;
        }
        return (left + right + mid) > 0;
    }
    lowestCommon(root, p, q);
    return result;
};
// @lc code=end

