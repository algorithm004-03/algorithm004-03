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
var postorder = function(root) {
    if (root == null) {
        return [];
    }
    let stArr = [root];
    let result = [];
    while (stArr.length > 0) {
        let d = stArr.pop();
        result.unshift(d.val);
        for (let i = 0; i < d.children.length; i++) {
            stArr.push(d.children[i]);
        }
    }
    return result;
};
// @lc code=end

