package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := TreeNode{Val: 1}
	root.Right = &TreeNode{2, nil, nil}
	root.Right.Left = &TreeNode{3, nil, nil}
	r := postorderTraversal(&root)
	fmt.Println(r)
}

func postorderTraversal(root *TreeNode) []int {
	var result []int
	helpers(root, &result)
	return result
}

func helpers(root *TreeNode, result *[]int) {
	if root == nil {
		return
	}
	if root.Left != nil {
		helpers(root.Left, result)
	}
	if root.Right != nil {
		helpers(root.Right, result)
	}
	*result = append(*result, root.Val)
}
