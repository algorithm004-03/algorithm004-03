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
    var result = [];
    search(root);

    function search(node){
        if (!node) {
            return null;
        }

        search(node.left);
        result.push(node.val);
        search(node.right);
    }

    return result;
};
