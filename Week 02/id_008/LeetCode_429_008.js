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
var levelOrder = function(root) {
    if (!root) {
        return [];
    }

    var result = [];
    result.push([root.val]);
    search(root, 1);

    function search(node, k){
        if (!node) {
            return null;
        }

        for (var i = 0; i < node.children.length; ++i) {
            if (typeof result[k] === "undefined") {
                result[k] = [];
            }

            result[k].push(node.children[i].val);
        }

        for (var i = 0; i < node.children.length; ++i) {
            search(node.children[i], k + 1);
        }
    }

    return result;
};
