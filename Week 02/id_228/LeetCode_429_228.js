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
let levelOrder = function(root) {
    if (!root) {
        return []
    }
    let result = []
    let helper = function(root, depth, result) {
        if (depth + 1 > result.length) {
            result[depth] = []
        }
        result[depth].push(root.val)
        for (let i = 0; i < root.children.length; i++) {
            helper(root.children[i], depth + 1, result)
        }
    }
    helper(root, 0, result)
    return result
};