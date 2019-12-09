package week02

/**
第二周 第6课作业

给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	var res []int

	inorder(root, &res)

	return res
}

func inorder(root *TreeNode, res *[]int) {
	if root != nil {
		if root.Left != nil {
			inorder(root.Left, res)
		}

		*res = append(*res, root.Val)

		if root.Right != nil {
			inorder(root.Right, res)
		}
	}
}