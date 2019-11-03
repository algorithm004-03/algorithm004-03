/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var res *TreeNode
	search(root, p, q, &res)
	return res
}

func search(node, p, q *TreeNode, res **TreeNode) (bool, bool) {
	if node == nil || *res != nil {
		return false, false
	}

	leftHasP, leftHasQ := search(node.Left, p, q, res)
	rightHasP, rightHasQ := search(node.Right, p, q, res)
	hasP := leftHasP || rightHasP || node.Val == p.Val
	hasQ := leftHasQ || rightHasQ || node.Val == q.Val

	if *res != nil && hasP && hasQ {
		*res = node
	}

	return hasP, hasQ
}
