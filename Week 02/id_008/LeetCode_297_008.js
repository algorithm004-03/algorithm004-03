 /**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    if (!root) {
        return "[]";
    }

    var nodeList = [root];
    var node;
    var result = [];

    while (nodeList.length) {
        node = nodeList.shift();

        if (node) {
            result.push(node.val);
            nodeList.push(node.left);
            nodeList.push(node.right);
        }
        else {
            result.push(null);
        }
    }

    while (result.length) {
        if (typeof result[result.length - 1] === "number") {
            break;
        }

        --result.length;
    }

    return JSON.stringify(result);
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    var data = JSON.parse(data);

    if (data.length <= 0) {
        return null;
    }

    var root = { val: data[0], left: null, right: null };
    var nodeList = [root];

    for (var i = 1; i < data.length; i += 2) {
        var node = nodeList.shift();

        if (!node) {
            i -= 2;
            continue;
        }

        if (typeof data[i] === "number") {
            node.left = { val: data[i], left: null, right: null };
            nodeList.push(node.left);
        }
        else {
            nodeList.push(null);
        }

        if (typeof data[i + 1] === "number") {
            node.right = { val: data[i + 1], left: null, right: null };
            nodeList.push(node.right);
        }
        else {
            nodeList.push(null);
        }
    }

    return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
