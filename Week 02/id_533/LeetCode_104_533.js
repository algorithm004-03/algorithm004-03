// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

/**
 * @param {TreeNode} root
 * @return {number}
 */
// 递归遍历 时间复杂度O(logn)
var maxDepth = function(root) {
    if (root === null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
};

// 节点
function TreeNode (val) {
    this.val = val;
    this.left = null;
    this.right = null;
}
// 二叉搜索树
function BinarySearchTree () {
    this.root = null;
}
// 添加节点
BinarySearchTree.prototype.insert = function (val) {
    if(val === null || val === undefined) return;
    var node = new TreeNode(val);
    if (!this.root) {
        this.root = node;
        return;
    }
    var cur = this._getTreeNode(val);
    if (val < cur.val) 
        cur.left = node;
    else
        cur.right = node;
}
// 在树中遍历查找可以添加val的节点
BinarySearchTree.prototype._getTreeNode = function (val, find = false) {
    var cur = this.root;
    while (true) {
        if (val < cur.val) {
            if (!cur.left) break;
            cur = cur.left;
        }
        if (val >= cur.val) {
            if (!cur.right) break;
            cur = cur.right;
        }
    }
    return cur;
}

var bst = new BinarySearchTree();
bst.insert(6);
bst.insert(1);
bst.insert(3);
bst.insert(4);
bst.insert(5);
bst.insert(8);
console.log(maxDepth(bst.root));