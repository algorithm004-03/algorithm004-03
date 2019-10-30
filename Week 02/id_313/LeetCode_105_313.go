package id313

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

// 主要是对 前序和中序遍历掌握够熟练
// 通过前序定位根结点，在中序中通过根结点找到左右节点区分。递归重复
func buildTree(preorder []int, inorder []int) *TreeNode {
	root := tree(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
	return root
}

func tree(preoder []int, preL, preR int, inorder []int, inL, inR int) *TreeNode {
	if preL > preR || inL > inR {
		return nil
	}
	pivot := preoder[preL]
	root := &TreeNode{Val: pivot}
	pivotIndex := inL
	for pivotIndex < inR && inorder[pivotIndex] != pivot {
		pivotIndex++
	}
	root.Left = tree(preoder, preL+1, pivotIndex-inL+preL, inorder, inL, pivotIndex-1)
	root.Right = tree(preoder, pivotIndex-inL+preL+1, preR, inorder, pivotIndex+1, inR)
	return root
}
