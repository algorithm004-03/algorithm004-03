/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
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
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    let res = [];

    inOrder(root, res);

    return res;
};

var inOrder = function (root, res) {
    if (root !== null) {
        if (root.left !== null) inOrder(root.left, res);
        res.push(root.val);
        if (root.right !== null) inOrder(root.right, res);
    }
};
// @lc code=end