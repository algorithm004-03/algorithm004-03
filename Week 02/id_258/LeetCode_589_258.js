/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function (root) {
    let res = [];

    preorderProcess(root, res);

    return res;
};

var preorderProcess = function (root, res) {
    if (root !== null) {
        res.push(root.val);

        root.children.forEach(element => {
            preorderProcess(element, res);
        });
    }
}

// @lc code=end