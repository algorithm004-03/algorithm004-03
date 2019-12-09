// https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/

/**
 * @param {Node} root
 * @return {number[]}
 */
// 递归遍历
// 时间复杂度O(n) 空间复杂度O(logn)
var preorder = function(root) {
    var result = [];
    traversal(root);
    return result;
    function traversal (root) {
        result.push(root.val);
        if (root === null) return;
        var length = root.length;
        for (var i = 0; i < length; i++) {
            traversal(root.children[i])
        }
    } 
};