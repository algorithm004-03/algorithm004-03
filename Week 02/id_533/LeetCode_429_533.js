// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

/**
 * @param {Node} root
 * @return {number[]}
 */
// 递归遍历
// 时间复杂度O(n) 空间复杂度O(logn)
var postorder = function(root) {
    var result = [];
    traversal(root);
    return result;
    function traversal (root) {
        if (root === null) return;
        var length = root.length;
        for (var i = 0; i < length; i++) {
            traversal(root.children[i])
        }
        result.push(root.val);
    } 
};

// 迭代遍历
var postorder = function(root) {
    if(root === null) return [];
    var result = [],
        stack = [],
        prev = null;
    stack.push(root);
    while(stack.length > 0) {
        var cur = stack.top();
        while (cur.children.length === 0 || cur.children.top() === prev) {
            prev = stack.pop();
            result.push(prev.val)
        }
        for (var i = cur.children.length - 1; i >= 0 ; i--) {
            stack.push(cur.children[i])
        }
    }
};

Array.prototype.top = function () {
    return this[this.length - 1]
}
