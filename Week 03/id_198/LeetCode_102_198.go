package leetcode

/**
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

// 本部分基于BFS（一种遍历或搜索树或图数据结构的算法。它从树根(或图的某个任意节点)开始，在进入下一个深度级别之前，探测当前深度的所有邻居节点
// 可能和老师的模板有一定出入, 本实现在完成当前节点遍历当前深度（所有）节点时将下一级节点缓存，以便下次访问。
// 每个节点在该过程中至少访问两次，因此时间复杂度为O(2b^d)=>O(b^d)
// 中间存在暂存行为，因此空间复杂度为O(b^d)
func levelOrder(root *TreeNode) [][]int {

	rt := make([][]int, 0)
	if root == nil {
		return rt
	}
	nodes := []*TreeNode{}
	nodes = append(nodes, root)
	level := 0
	for len(nodes) > 0 {

		rt = append(rt, make([]int, 0))
		next := []*TreeNode(nil)
		for i := 0; i < len(nodes); i++ {

			rt[level] = append(rt[level], nodes[i].Val)
			if nodes[i].Left != nil {

				next = append(next, nodes[i].Left)
			}
			if nodes[i].Right != nil {

				next = append(next, nodes[i].Right)
			}
		}
		nodes = next
		level++
	}
	return rt
}
