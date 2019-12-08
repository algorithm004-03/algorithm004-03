/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	res := &[]int{}
	traverse(root, res)
	return *res
}

func traverse(node *TreeNode, res *[]int) {
	if node == nil {
		return
	}

	*res = append(*res, node.Val)
	traverse(node.Left, res)
	traverse(node.Right, res)
}

func preorderTraversalV2(root *TreeNode) []int {
	var res []int
	if root == nil {
		return res
	}

	s := NewStack()
	cur := root
	for {
		res = append(res, cur.Val)
		if cur.Right != nil {
			s.push(cur.Right)
		}

		cur = cur.Left
		if cur == nil {
			if n, ok := s.pop(); ok {
				cur = n
			} else {
				break
			}
		}
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

func (s *stack) pop() (*TreeNode, bool) {
	if s.idx == 0 {
		return nil, false
	}

	s.idx--
	return s.buf[s.idx], true
}
