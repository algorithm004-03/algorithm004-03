/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/** 递归
 * @param {TreeNode} root
 * @return {number[]}
 */
// var inorderTraversal = function(root) {
//     const res = [];
//     function helper(root, res) {
//         if(root){
//         if(root.left) {
//                 helper(root.left, res)
//             }
//             res.push(root.val)
//             if(root.right) {
//                 helper(root.right,res)
//             }
//         }
//     }
//     helper(root, res);
//     return res;

// };

/**
*栈
*/
var inorderTraversal = function(root) {
    let res = [];
    let stack = [];
    let curr = root;
    while(curr !== null || stack.length > 0) {
        while(curr!== null) {
            stack.unshift(curr)
            curr = curr.left;
        }
        curr = stack.shift();
        res.push(curr.val)
       curr = curr.right;
    }
    return res;
} 