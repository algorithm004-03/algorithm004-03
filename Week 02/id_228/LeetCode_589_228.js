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
    let result = []
    let helper = function(root) {
        if (root) {
            result.push(root.val)
            let len = root.children.length
            for (let i = 0; i < len; i++) {
              helper(root.children[i]);
            }
        }
    }
    helper(root)
    return result
};