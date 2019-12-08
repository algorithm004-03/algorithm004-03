/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
	res := &[]int{}
	traverse(root, res)
	return *res
}

func traverse(node *TreeNode, res *[]int) {
	if node == nil {
		return
	}

	traverse(node.Left, res)
	*res = append(*res, node.Val)
	traverse(node.Right, res)
}

func inorderTraversalV2(root *TreeNode) []int {
	var res []int
	s := NewStack()
	cur := root
	for cur != nil || !s.isEmpty() {
		for cur != nil {
			s.push(cur)
			cur = cur.Left
		}

		cur = s.pop()
		res = append(res, cur.Val)
		cur = cur.Right
	}

	return res
}

func inorderTraversalV3(root *TreeNode) []int {
	var res []int
	cur := root
	for cur != nil {
		if cur.Left != nil {
			prev := cur.Left
			for prev.Right != nil {
				prev = prev.Right
			}

			prev.Right = cur
			temp := cur.Left
			cur.Left = nil
			cur = temp
			continue
		}

		res = append(res, cur.Val)
		cur = cur.Right
	}

	return res
}

type stack struct {
	buf []*TreeNode
	idx int
}

func NewStack() stack {
	s := stack{}
	s.buf = make([]*TreeNode, 16)
	return s
}

func (s *stack) push(node *TreeNode) {
	if s.idx == len(s.buf) {
		s.buf = append(s.buf, node)
	} else {
		s.buf[s.idx] = node
	}

	s.idx++
}

func (s *stack) isEmpty() bool {
	return s.idx == 0
}

func (s *stack) pop() *TreeNode {
	if s.isEmpty() {
		return nil
	}

	s.idx--
	return s.buf[s.idx]
}
