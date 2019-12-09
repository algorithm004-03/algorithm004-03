/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
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
var preorderTraversal = function (root) {
    let res = [];

    preorderProcess(root, res);

    return res;
};

var preorderProcess = function (root, res) {
    if (root !== null) {
        res.push(root.val);

        if (root.left !== null) {
            preorderProcess(root.left, res);
        }

        if (root.right !== null) {
            preorderProcess(root.right, res);
        }

    }
}

// @lc code=end