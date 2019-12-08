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
  let result = [];
  let helper = function(root) {
    if (root) {
      if (root.children && root.children.length > 0) {
        for (let i = 0; i < root.children.length; i++) {
          helper(root.children[i]);
        }
      }
      result.push(root.val);
    }
  };
  helper(root);
  return result;
};
