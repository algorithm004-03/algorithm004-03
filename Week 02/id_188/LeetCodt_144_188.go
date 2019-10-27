/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
package leetCode

func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	leftRoot := preorderTraversal(root.Left)
	rightRoot := preorderTraversal(root.Right)
	return append(append([]int{root.Val}, leftRoot...), rightRoot...)
}

// @lc code=end
