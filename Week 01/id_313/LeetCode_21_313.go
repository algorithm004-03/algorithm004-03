package id313

// ListNode 结点
type ListNode struct {
	Val  int
	Next *ListNode
}

// 弄一个哨兵节点 最后比较容易返回数据 两个链表从前到后 比较大小
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	l := new(ListNode)
	prev := l
	for l1 != nil || l2 != nil {
		if l1 == nil && l2 != nil {
			prev.Next = l2
			l2 = l2.Next
			prev = prev.Next
			continue
		}

		if l2 == nil && l1 != nil {
			prev.Next = l1
			l1 = l1.Next
			prev = prev.Next
			continue
		}
		if l1.Val > l2.Val {
			prev.Next = l2
			l2 = l2.Next
			prev = prev.Next
		} else {
			prev.Next = l1
			l1 = l1.Next
			prev = prev.Next
		}
	}
	return l.Next
}
