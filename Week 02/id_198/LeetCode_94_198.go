package leetcode

//TreeNode TreeNode
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {

	rt := make([]int, 0)
	if root == nil {

		return rt
	}
	if root.Left != nil {

		for _, v := range inorderTraversal(root.Left) {

			rt = append(rt, v)
		}
	}
	rt = append(rt, root.Val)
	if root.Right != nil {

		for _, v := range inorderTraversal(root.Right) {

			rt = append(rt, v)
		}
	}

	return rt
}
