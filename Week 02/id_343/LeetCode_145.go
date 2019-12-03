/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func postorderTraversal(root *TreeNode) []int {
    if root == nil {
        return nil
    }
    
    l := postorderTraversal(root.Left)
    r := postorderTraversal(root.Right)
    
    return append(append(l, r...), root.Val)
}
