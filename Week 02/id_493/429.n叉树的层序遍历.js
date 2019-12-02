/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
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
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (root == null) {
        return [];
    }
    let stArr = [{level: 0, value: root}];
    let result1 = [];
    while (stArr.length > 0) {
        let d = stArr.shift();
        let level = d.level;
        let value = d.value;
        result1[level] = result1[level] || [];
        result1[level].push(d.value.val);
  
        for (let i = 0; i < value.children.length; i++) {
            stArr.push({level: level + 1, value: value.children[i]});
        }
    }
    return result1;
};
// @lc code=end

