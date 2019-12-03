/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{}
	cur := dummy

	var l *ListNode
	for l1 != nil && l2 != nil {
		if l1.Val > l2.Val {
			l = l2
			l2 = l2.Next
		} else {
			l = l1
			l1 = l1.Next
		}

		cur.Next = l
		cur = cur.Next
	}

	if l1 == nil {
		l = l2
	} else {
		l = l1
	}

	cur.Next = l
	return dummy.Next
}

