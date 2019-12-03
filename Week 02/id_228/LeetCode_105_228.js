/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    if (!preorder.length || !inorder.length) {
        return null
    }
    let root = preorder[0]
    let inorderRootPosition = inorder.indexOf(root)
    let inorderLeft = inorder.slice(0, inorderRootPosition)
    let inorderRight = inorder.slice(inorderRootPosition + 1)
    let preorderLeft = preorder.slice(1, inorderRootPosition + 1)
    let preorderRight = preorder.slice(inorderRootPosition + 1)
    
    let tree = new TreeNode(root)
    tree.left = buildTree(preorderLeft,inorderLeft)
    tree.right = buildTree(preorderRight,inorderRight)
    return tree
    
};