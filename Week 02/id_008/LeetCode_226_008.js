/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
    changeNode(root);
    return root;

    function changeNode(node){
        if (!node) {
            return null;
        }

        var temp = node.left;
        node.left = node.right;
        node.right = temp;
        changeNode(node.left);
        changeNode(node.right);
    }
};
