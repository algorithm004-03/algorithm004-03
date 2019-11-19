/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(inorder) == 0 {
		return nil
	}

	cur := preorder[0]
	mid := 0
	for mid < len(inorder) {
		if inorder[mid] == cur {
			break
		}

		mid++
	}

	left := buildTree(preorder[1:mid+1], inorder[0:mid])
	right := buildTree(preorder[mid+1:], inorder[mid+1:])
	node := &TreeNode{Val: cur, Left: left, Right: right}
	return node
}
