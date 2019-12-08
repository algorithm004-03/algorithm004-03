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
var minDepth = function(root) {
    if (!root) {
        return 0;
    }

    var min = Infinity;
    search(root, 1);

    function search(node, deep){
        if (!node) {
            return null;
        }

        if (!node.left && !node.right) {
            if (deep < min) {
                min = deep;
            }
        }

        search(node.left, deep + 1);
        search(node.right, deep + 1);
    }

    return min;
};
