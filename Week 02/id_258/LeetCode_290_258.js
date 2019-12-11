/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
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
var postorder = function (root) {
    let res = [];

    postorderProcess(root, res);

    return res;
};

var postorderProcess = function (root, res) {
    if (root !== null) {
        for (let i = 0; i < root.children.length; i++) {
            postorderProcess(root.children[i], res);
        }
        res.push(root.val)
    }
}
// @lc code=end