package id313

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || root == p || root == q {
		return root
	}
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)

	// left == nil 表示 p 和 q 不在 left中
	// right == nil 表示 p he q 不在right中
	// left 和 right 不能同时为 nil
	if left != nil && right != nil {
		// p 和 q 在 root.Left 和 root.Right 中
		return root
	}
	// p 和 q 在 root.Right 中
	if left == nil {
		return right
	}
	// p 和 q 在 root.Left 中
	return left

}
