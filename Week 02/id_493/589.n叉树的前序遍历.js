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
var preorder = function(root) {
    if (root == null) {
        return [];
    }
    let stArr = [root];
    let result = [];
    while (stArr.length > 0) {
        let d = stArr.pop();
        result.push(d.val);
        for (let i = d.children.length - 1; i >= 0; i--) {
            stArr.push(d.children[i]);
        }
    }
    return result;
};
// @lc code=end

