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
    var result = [];
    search(root);

    function search(node){
        if (!node) {
            return null;
        }

        for (var i = 0; i < node.children.length; ++i) {
            search(node.children[i]);
        }

        result.push(node.val);
    }

    return result;
};
