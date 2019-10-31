package week02

/**
第二周 第6课作业

给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {
	var res []int

	preorder(root, &res)

	return res
}

func preorder(root *TreeNode, res *[]int) {
	if root != nil {
		*res = append(*res, root.Val)

		if root.Left != nil {
			preorder(root.Left, res)
		}

		if root.Right != nil {
			preorder(root.Right, res)
		}
	}
}