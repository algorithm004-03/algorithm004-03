// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

/**
 * @param {Node} root
 * @return {number[][]}
 */
// 迭代法
// 时间复杂度O(n) 空间复杂度O(n)
var levelOrder = function(root) {
    if (root === null) return [];
    var result = [],
        queue = [];
    queue.push({ level: 0, node: root });
    while (queue.length > 0) {
        var cur = queue.shift();
        var level = cur.level;
        if (!result[level]) result[level] = [];
        result[level].push(cur.node.val);
        for(var child of cur.node.children) {
            queue.push({ level: level + 1, node: child} )
        }
    }
    return result;
};