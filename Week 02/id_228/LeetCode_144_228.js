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
  let result = [];
  let pushRoot = function(root) {
    if (root) {
      result.push(root.val);
      if (root.left) {
        pushRoot(root.left);
      }
      if (root.right) {
        pushRoot(root.right);
      }
    }
  };
  pushRoot(root);
  return result;
};
