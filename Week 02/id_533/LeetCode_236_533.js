// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    return recurseTree(root, p, q)
    function recurseTree (root, p, q) {
        if (root === null || root === p || root === q) return root; // 递归终止条件
        var left = recurseTree(root.left, p, q);
        var right = recurseTree(root.right, p, q);
        return left ? (right ? root : left) : right
    }
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
bst.insert(45);
bst.insert(40);
bst.insert(50);
bst.insert(35);
bst.insert(42);
bst.insert(48);

console.log(lowestCommonAncestor(bst.root, bst.root.left.left, bst.root.left.right))