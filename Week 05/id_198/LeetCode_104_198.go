package leetcode

import "math"

/*
 *
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {

	if root == nil {

		return 0
	}

	if root.Left == nil && root.Right == nil {

		return 1
	}

	if root.Left == nil {

		return maxDepth(root.Right) + 1
	}

	if root.Right == nil {

		return maxDepth(root.Left) + 1
	}

	return int(math.Max(float64(maxDepth(root.Left)), float64(maxDepth(root.Right)))) + 1
}
