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
var inorderTraversal = function(root) {

    if (root == null) {
        return [];
    }

    let result = [];
    let stArr = [root];
    while (stArr.length > 0) {
        let ff = stArr.pop();
        result.push(ff.val);
        if (ff.right !== null) {
            stArr.push(ff.right);
        }
        if (ff.left !== null) {
            stArr.push(ff.left);
        }
    }
    return result;



    // let result = [];
    // let stArr = [];
    // while (root != null || stArr.length > 0) {
    //     while (root !== null) {
    //         stArr.push(root);
    //         root = root.left;
    //     }
    //     root = stArr.pop();
    //     result.push(root.val);
    //     root = root.right;
    // }
    // return result;
};
// @lc code=end

