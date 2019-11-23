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
    let result = []
    var pushRoot = function(root) {
        if (root) {
            if (root.left) {
                pushRoot(root.left)
            }
            result.push(root.val)
            if (root.right) {
                pushRoot(root.right)
            }
        }
    }
    pushRoot(root)
    return result
};