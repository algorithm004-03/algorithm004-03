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
var preorderTraversal = function(root) {
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
    // result.push(root.val);

    // let left = postorderTraversal(root.left);
    // let right = postorderTraversal(root.right);
    // result.push(...left);
    // result.push(...right);
    
    // return result;

    // let result = [];
    // let stArr = [];
    // while (root != null || stArr.length > 0) {
    //     while (root !== null) {
    //         stArr.push(root);
    //         result.push(root.val);
    //         root = root.left;
    //     }
    //     root = stArr.pop();
    //     root = root.right;
    // }
    // return result;
};
// @lc code=end

