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
var largestValues = function(root) {
    var result = [];
    search(root, 0);

    for (var i = 0; i < result.length; ++i) {
        result[i] = max(result[i]);
    }

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

    function max(arr){
        var max = arr[0];

        for (var i = 1; i < arr.length; ++i) {
            arr[i] > max && (max = arr[i]);
        }

        return max;
    }
};
