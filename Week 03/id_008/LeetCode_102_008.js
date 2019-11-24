/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    var result = [];
    search(root, 0);
    return result;

    function search(node, level){
        if (!node) {
            return false;
        }

        if (typeof result[level] === "undefined") {
            result[level] = [];
        }

        result[level].push(node.val);
        search(node.left , level + 1);
        search(node.right, level + 1);
    }
};
