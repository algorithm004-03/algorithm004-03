/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    var max = -Infinity;
    search(root, 0);

    function search(node, deep){
        if (!node) {
            if (deep > max) {
                max = deep;
            }

            return null;
        }

        search(node.left, deep + 1);
        search(node.right, deep + 1);
    }

    return max;
};
