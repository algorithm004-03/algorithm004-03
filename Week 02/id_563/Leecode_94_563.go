/**
 * 用了helper的方法
 * 学了一下6.2的染色思路
 */
func inorderTraversal(root *TreeNode) []int {
    ret := make([]int, 0)
	if root == nil {
		return ret
	}
	stack := list.New()
	for root != nil || stack.Len() != 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}
		root = stack.Back().Value.(*TreeNode)
		ret = append(ret, root.Val)
		stack.Remove(stack.Back())
		root = root.Right
	}
	return ret
}
