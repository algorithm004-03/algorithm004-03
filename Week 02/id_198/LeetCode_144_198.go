package leetcode

//TreeNode TreeNode
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {

	rt := make([]int, 0)
	if root == nil {

		return rt
	}
	rt = append(rt, root.Val)
	if root.Left != nil {

		for _, v := range preorderTraversal(root.Left) {

			rt = append(rt, v)
		}
	}
	if root.Right != nil {

		for _, v := range preorderTraversal(root.Right) {

			rt = append(rt, v)
		}
	}

	return rt
}
