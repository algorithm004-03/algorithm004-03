// https://leetcode-cn.com/problems/validate-binary-search-tree/

/**
 * @param {TreeNode} root
 * @param {TreeNode} prev
 * @param {TreeNode} next
 * @return {boolean}
 */
// 递归
var isValidBST = function(root, prev, next) {
    if (root === null) return true;
    if(prev && prev.val >= root.val) return false;
    if(next && next.val <= root.val) return false;
    return isValidBST(root.left, prev, root) && isValidBST(root.right, root, next);
};

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
// 中序遍历
var isValidBST = function(root) {
    var stack = [],
        prev = Number.MIN_VALUE,
        cur = root;
    while (cur || stack.length > 0) {
        while (cur) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        if(prev >= cur.val) return false;
        prev = cur.val;
        cur = cur.right
    }
    return true;
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
console.log(isValidBST(bst.root));
