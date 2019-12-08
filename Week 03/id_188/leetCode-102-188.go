/*
 * @lc app=leetcode.cn id=102 lang=golang
 *
 * [102] 二叉树的层次遍历
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

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	ret := [][]int{}

	// 深度优先
	var dfsFunc func(root *TreeNode, level int)
	dfsFunc = func(root *TreeNode, level int) {
		if root == nil {
			return
		}
		if level == len(ret) {
			ret = append(ret, []int{root.Val})
		} else {
			ret[level] = append(ret[level], root.Val)
		}
		dfsFunc(root.Left, level+1)
		dfsFunc(root.Right, level+1)
	}
	dfsFunc(root, 0)

	// 广度优先
	// var bfsFunc func(root *TreeNode)
	// bfsFunc = func(root *TreeNode) {
	// 	if root == nil {
	// 		return
	// 	}
	// 	level, queue := 0, list.New()
	// 	queue.PushBack(interface{}(root))
	// 	for queue.Len() > 0 {
	// 		length, element := queue.Len(), []int{}
	// 		for i := 0; i < length; i++ {
	// 			node := queue.Remove(queue.Front()).(*TreeNode)
	// 			element = append(element, node.Val)
	// 			if node.Left != nil {
	// 				queue.PushBack(interface{}(node.Left))
	// 			}
	// 			if node.Right != nil {
	// 				queue.PushBack(interface{}(node.Right))
	// 			}
	// 		}
	// 		ret = append(ret, element)
	// 		level++
	// 	}
	// }
	// bfsFunc(root)

	return ret
}

// @lc code=end
