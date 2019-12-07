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
    var result = [];
    search(root);

    function search(node){
        if (!node) {
            return null;
        }

        result.push(node.val);

        for (var i = 0; i < node.children.length; ++i) {
            search(node.children[i]);
        }
    }

    return result;
};
