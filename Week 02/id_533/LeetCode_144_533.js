// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
// 递归遍历
// 时间复杂度O(n) 空间复杂度O(logn)
var preorderTraversal = function(root) {
    var result = [];
    traversal(root);
    return result;
    function traversal (root) {
        if (root === null) return;
        result.push(root.val);
        traversal(root.left);
        traversal(root.right);
    }
};

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
// 莫里斯遍历
// 时间复杂度O(n) 空间复杂度O(1)
var preorderTraversal = function(root) {
    var result = [],
        cur = root;
    while (cur) {
        result.push(cur.val)
        if (cur.left) {
            var pre = cur.left;
            while (pre.right) pre = pre.right;
            if (cur.right) pre.right = cur.right;
            var tmp = cur;
            cur = cur.left;
            tmp = null;
        } else {
            cur = cur.right;
        }
    }
    return result;
};

// 节点
function TreeNode (val) {
    this.val = val;
    this.left = null;
    this.right = null;
}

// 二叉搜索树
function SearchTree () {
    this.root = null;
}

// 添加节点
SearchTree.prototype.insert = function (val) {
    if(val === null || val === undefined) return;
    var node = new TreeNode(val);
    if (!this.root) {
        this.root = node;
        return;
    }
    var curNode = this._getTreeNode(val);
    if (val < curNode.val) 
        curNode.left = node;
    else
        curNode.right = node;
}

// 在树中遍历查找可以添加val的节点
SearchTree.prototype._getTreeNode = function (val) {
    var curNode = this.root;
    while (true) {
        if (val < curNode.val) {
            if (!curNode.left) break;
            curNode = curNode.left;
        }
        if (val >= curNode.val) {
            if (!curNode.right) break;
            curNode = curNode.right;
        }
    }
    return curNode;
}

var searchTree = new SearchTree();
searchTree.insert(1);
searchTree.insert(null);
searchTree.insert(2);
searchTree.insert(3);

var result = preorderTraversal(searchTree.root)
console.log(result);