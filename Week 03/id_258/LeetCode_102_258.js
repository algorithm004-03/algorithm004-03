/*
 * @lc app=leetcode.cn id=102 lang=javascript
 *
 * [102] 二叉树的层次遍历
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
 * @return {number[][]}
 */
var levelOrder = function (root) {
    let result = [];
    let level = 0;

    var dfs = function (root, level) {
        if (!root) {
            return;
        }

        if (level >= result.length) {
            result[level] = [];
        }
        result[level].push(root.val);
        level++
        dfs(root.left, level)
        dfs(root.right, level)
    }

    dfs(root, level);
    return result;
};
// @lc code=end