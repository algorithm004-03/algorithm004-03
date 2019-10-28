/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
    if root == nil {
        return nil
    }
    
    l := preorderTraversal(root.Left)
    r := preorderTraversal(root.Right)
    
    return append(append([]int{root.Val}, l...), r...)
}
